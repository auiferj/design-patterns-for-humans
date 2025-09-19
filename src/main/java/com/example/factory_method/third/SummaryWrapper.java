package com.example.factory_method.third;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.Map;

public class SummaryWrapper extends BaseControllerWrapper {
    public SummaryWrapper(Object obj) {
        super(obj);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        //会议时间
        Date beginTime = (Date) map.get("beginTime");
        String beginTimeS = DateFormatUtils.format(beginTime, "yyyy-MM-dd HH:mm");
        Date endTime = (Date) map.get("endTime");
        String endTimeS = DateFormatUtils.format(endTime, "yyyy-MM-dd HH:mm");
        map.put("timeRange", beginTimeS + "至" + endTimeS);
    }
}
