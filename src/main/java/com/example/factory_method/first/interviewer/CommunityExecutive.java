package com.example.factory_method.first.interviewer;

/**
 * 社区支援
 */
public class CommunityExecutive implements Interviewer {
    @Override
    public void askQuestions() {
        System.out.println("Asking about community building");
    }
}
