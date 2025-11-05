package com.example.behavioral.visitor.demo_3;

// 3️⃣ 具体元素类：工程师
class Engineer implements Employee {
    private String name;

    public Engineer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // 关键：把自己“交给”访问者处理
    }
}
