package com.example.behavioral.observer.first;

// 求职者类 - 实现观察者接口
class JobSeeker implements Observer {
    private String name;

    public JobSeeker(String name) {
        this.name = name;
    }

    @Override
    public void onJobPosted(String jobPosting) {
        // 处理职位发布通知
        System.out.println("Hi " + this.name + "! New job posted: " + jobPosting);
    }
}
