package com.example.creational.prototype.second_deep;

import java.util.ArrayList;
import java.util.List;
// 如果没有实现 Cloneable，super.clone() 会抛出 CloneNotSupportedException
public class Sheep implements Cloneable{
    protected String name;
    protected String category;
    protected List<String> traits; // 引用类型字段

    public Sheep(String name) {
        this(name, "Mountain Sheep");
    }

    public Sheep(String name, String category) {
        this.name = name;
        this.category = category;
        this.traits = new ArrayList<>();
    }

    public void addTrait(String trait) {
        this.traits.add(trait);
    }

    public List<String> getTraits() {
        return new ArrayList<>(this.traits); // 返回副本以防外部修改
    }

    @Override
    public Sheep clone() {// 将访问权限从protected改为public
        try {
            Sheep cloned = (Sheep) super.clone();// 先进行浅拷贝：只复制引用，不复制引用指向的对象.调用Object的本地克隆方法
            // 对引用类型进行深拷贝
            cloned.traits = new ArrayList<>(this.traits);// 创建新的ArrayList
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();// 理论上不会发生，因为实现了Cloneable
        }
    }

    @Override
    public String toString() {
        return "Sheep{name='" + name + "', category='" + category + "', traits=" + traits + "}";
    }
}
