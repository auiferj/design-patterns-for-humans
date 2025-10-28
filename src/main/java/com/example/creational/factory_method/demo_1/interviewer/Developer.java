package com.example.creational.factory_method.demo_1.interviewer;

/**
 * 开发面试官
 * 角色：具体产品
 */
public class Developer implements Interviewer {
    @Override
    public void askQuestions() {
        System.out.println("Asking about design patterns!");
    }
}
