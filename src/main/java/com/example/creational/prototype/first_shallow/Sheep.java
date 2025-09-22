package com.example.creational.prototype.first_shallow;

public class Sheep implements Cloneable{
    protected String name;
    protected String category;

    public Sheep(String name) {
        this(name, "Mountain Sheep");
    }

    public Sheep(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    // 实现克隆方法
    @Override
    public Sheep clone() {
        try {
            return (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // 不应该发生，因为实现了Cloneable
        }
    }

    @Override
    public String toString() {
        return "Sheep{name='" + name + "', category='" + category + "'}";
    }
}
