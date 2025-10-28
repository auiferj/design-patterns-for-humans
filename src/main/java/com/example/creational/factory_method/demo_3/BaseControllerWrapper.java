package com.example.creational.factory_method.demo_3;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 控制器查询结果的包装类基类
 */
public abstract class BaseControllerWrapper {

	public Object obj = null;

	public BaseControllerWrapper(Object obj) {
		this.obj = obj;
	}

	@SuppressWarnings("unchecked")
	public Object wrap() {
		try {
			if (this.obj instanceof List) {
				List<Object> list = (List<Object>) this.obj;
				List<Map<String, Object>> returnList = new ArrayList<>();
				for (Object _obj : list) {
					Map<String, Object> _map = new HashMap<>();
					if (_obj instanceof Map) {
						_map = (Map<String, Object>) _obj;
					} else {
						_map = objectToMap(_obj);
					}
					wrapTheMap(_map);
					returnList.add(_map);
				}
				return returnList;
			} else if (this.obj instanceof Map) {
				Map<String, Object> map = (Map<String, Object>) this.obj;
				wrapTheMap(map);
				return map;
			} else {
				Map<String, Object> map = objectToMap(this.obj);
				wrapTheMap(map);
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Object> objectToMap(Object obj) throws Exception {
		if (obj == null)
			return null;

		Map<String, Object> map = new HashMap<String, Object>();

		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			String key = property.getName();
			if (key.compareToIgnoreCase("class") == 0) {
				continue;
			}
			Method getter = property.getReadMethod();
			Object value = getter != null ? getter.invoke(obj) : null;
			map.put(key, value);
		}

		return map;
	}

	protected abstract void wrapTheMap(Map<String, Object> map);
}
