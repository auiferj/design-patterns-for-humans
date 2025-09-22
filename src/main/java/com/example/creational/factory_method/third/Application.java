package com.example.creational.factory_method.third;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Summary summary0 = new Summary(new Date(),new Date());
        Summary summary1 = new Summary(new Date(),new Date());
        List<Summary> summaryList = new ArrayList<>();
        summaryList.add(summary0);
        summaryList.add(summary1);
        Object wrap = new SummaryWrapper(summaryList).wrap();
        System.out.println(wrap);
    }
}
