package com.example.behavioral.observer.first;

public class ObserverDemo {
    public static void main(String[] args) {
        // 创建订阅者
        JobSeeker johnDoe = new JobSeeker("John Doe");
        JobSeeker janeDoe = new JobSeeker("Jane Doe");

        // 创建发布者并附加订阅者
        EmploymentAgency jobPostings = new EmploymentAgency();
        jobPostings.attach(johnDoe);
        jobPostings.attach(janeDoe);

        // 添加新职位并查看订阅者是否收到通知
        jobPostings.addJob(new JobPost("Software Engineer"));

        // 输出：
        // Hi John Doe! New job posted: Software Engineer
        // Hi Jane Doe! New job posted: Software Engineer
    }
}
