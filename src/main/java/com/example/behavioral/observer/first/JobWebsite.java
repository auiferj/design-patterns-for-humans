package com.example.behavioral.observer.first;

import java.util.ArrayList;
import java.util.List;

// 招聘网站类 - 实现被观察者接口
class JobWebsite implements Observable {
    private List<Observer> observers = new ArrayList<>();

    protected void notify(String jobPosting) {
        for (Observer observer : observers) {
            observer.onJobPosted(jobPosting);
        }
    }

    /**
     * 关注（求职者关注招聘网站）
     * @param observer
     */
    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * 发布职位
     * @param jobPosting 照片启示
     */
    @Override
    public void addJob(String jobPosting) {
        this.notify(jobPosting);
    }
}
