package com.example.creational.factory_method.first.manager;

import com.example.creational.factory_method.first.interviewer.Interviewer;

/**
 * 人事经理
 */
public abstract class HiringManager {
    // 工厂方法---子类决定具体实现
    protected abstract Interviewer makeInterviewer();

    public void takeInterview() {
        // 直到这里才调用工厂方法创建对象
        Interviewer interviewer = this.makeInterviewer();
        interviewer.askQuestions();
    }
}
