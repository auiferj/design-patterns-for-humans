package com.example.factory_method.first.manager;

import com.example.factory_method.first.interviewer.Developer;
import com.example.factory_method.first.interviewer.Interviewer;

/**
 * 新增产品时，只需要添加新的工厂方法实现，符合"开闭原则"
 */
public class DevelopmentManager extends HiringManager {
    @Override
    protected Interviewer makeInterviewer() {
        return new Developer();
    }
}
