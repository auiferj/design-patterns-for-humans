package com.example.creational.builder.second;

/**
 * 营养成分
 * 可伸缩构造函数---反模式
 * 为什么反模式
 * 1.难以编写和阅读（当只想设置servingSize，servings，carbohydrate，必须调用一个包含所有参数的构造函数，对不需要的参数传入0或null）
 * 2.易出错（参数必须严格正确，如果顺序不对会编译报错）
 * 3.缺乏灵活性（随着参数的增多，构造函数的数量会呈指数级增长）
 */
public class NutritionFacts {
    private final int servingSize;  // (mL) required - 必选
    private final int servings;     // (per container) required - 必选
    private final int calories;     // optional - 可选
    private final int fat;          // (g) optional - 可选
    private final int sodium;       // (mg) optional - 可选
    private final int carbohydrate; // (g) optional - 可选

    // 第一个构造函数：只有必选参数
    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    // 第二个构造函数：比上一个多一个可选参数 calories
    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    // 第三个构造函数：比上一个多一个可选参数 fat
    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    // 第四个构造函数：比上一个多一个可选参数 sodium
    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    // 终极构造函数：包含所有参数
    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
