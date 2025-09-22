package com.example.creational.builder.second;

public class NutritionFactsMain {
    public static void main(String[] args) {
        // 代码清晰、安全、易于阅读
        NutritionFacts_ cocaCola = new NutritionFacts_.Builder(240, 8) // 必选参数
                .calories(100) // 设置可选参数
                .sodium(35)    // 设置可选参数
                .carbohydrate(27) // 设置可选参数
                .build(); // 构建最终对象
    }
}
