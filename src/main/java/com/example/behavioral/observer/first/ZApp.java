package com.example.behavioral.observer.first;

public class ZApp {
    public static void main(String[] args) {
        // 创建订阅者
        JobSeeker johnDoe = new JobSeeker("John Doe");
        JobSeeker janeDoe = new JobSeeker("Jane Doe");

        // 创建发布者并附加订阅者
        JobWebsite jobWebsite = new JobWebsite();
        jobWebsite.attach(johnDoe);
        jobWebsite.attach(janeDoe);

        // 添加新职位并查看订阅者是否收到通知
        jobWebsite.addJob("软件工程师");

    }
}
