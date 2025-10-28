package com.example.creational.factory_method.demo_1.interviewer;

/**
 * 社区支援面试官
 * 角色：具体产品
 */
public class CommunityExecutive implements Interviewer {
    @Override
    public void askQuestions() {
        System.out.println("Asking about community building");
    }
}
