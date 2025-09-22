package com.example.creational.factory_method.first.interviewer;

/**
 * 开发
 */
public class Developer implements Interviewer {
    @Override
    public void askQuestions() {
        System.out.println("Asking about design patterns!");
    }
}
