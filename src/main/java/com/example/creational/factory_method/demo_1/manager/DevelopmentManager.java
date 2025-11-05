package com.example.creational.factory_method.demo_1.manager;

import com.example.creational.factory_method.demo_1.interviewer.Developer;
import com.example.creational.factory_method.demo_1.interviewer.Interviewer;

/**
 * 新增产品时，只需要添加新的工厂方法实现，符合"开闭原则"
 * 角色：具体工厂
 */
public class DevelopmentManager extends HiringManager {
    @Override
    protected Interviewer makeInterviewer() {
        return new Developer();
    }
}
