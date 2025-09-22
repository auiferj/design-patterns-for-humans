package com.example.creational.builder.second;

public class NutritionFacts_ {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    // 构造函数变为私有，只被 Builder 调用
    private NutritionFacts_(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    // 静态内部类 Builder
    public static class Builder {
        // 必选参数
        private final int servingSize;
        private final int servings;
        // 可选参数 - 提供默认值
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        // Builder的构造函数只接收必选参数
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        // 为每个可选参数提供设置方法，并返回Builder本身（用于链式调用）
        public Builder calories(int val) {
            calories = val;
            return this;
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        // 最终的构建方法
        public NutritionFacts_ build() {
            return new NutritionFacts_(this);
        }
    }
}
