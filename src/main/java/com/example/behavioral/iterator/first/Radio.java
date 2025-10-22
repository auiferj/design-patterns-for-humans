package com.example.behavioral.iterator.first;

/**
 * 聚合对象 - 收音机
 * 负责管理频率数据和提供迭代器
 */
class Radio {
    private double[] frequencies;//这个变量放在这里也没什么用
    private ExtendedIterator<Double> iterator;

    public Radio(double[] frequencies) {
        this.frequencies = frequencies;//没啥用
        this.iterator = new RadioIterator(frequencies);
    }

    public ExtendedIterator<Double> getIterator() {
        return iterator;
    }

    // 收音机的基本操作
    public void tuneToFrequency(double frequency) {
        System.out.println("调到频率: " + frequency + " MHz");
    }
}
