package com.example.creational.factory_method.demo_1.manager;

import com.example.creational.factory_method.demo_1.interviewer.Interviewer;

/**
 * 人事经理
 * 角色：抽象工厂
 */
public abstract class HiringManager {
    // 工厂方法---子类决定具体实现
    protected abstract Interviewer makeInterviewer();

    // 进行面试
    public void takeInterview() {
        // 直到这里才调用工厂方法创建对象
        Interviewer interviewer = this.makeInterviewer();
        interviewer.askQuestions();
    }
}
