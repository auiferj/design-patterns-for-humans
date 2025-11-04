package com.example.behavioral.observer.first;

// 被观察者接口
interface Observable {
    void attach(Observer observer);
    void addJob(String jobPosting);
}
