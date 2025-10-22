package com.example.behavioral.observer.first;

import java.util.ArrayList;
import java.util.List;

// 招聘机构类 - 实现被观察者接口
class EmploymentAgency implements Observable {
    private List<Observer> observers = new ArrayList<>();

    protected void notify(JobPost jobPosting) {
        for (Observer observer : observers) {
            observer.onJobPosted(jobPosting);
        }
    }

    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void addJob(JobPost jobPosting) {
        this.notify(jobPosting);
    }
}
