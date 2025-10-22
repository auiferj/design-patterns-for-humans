package com.example.behavioral.iterator.first;

// 使用收音机
public class RadioDemo {
    public static void main(String[] args) {
        double[] radioFrequencies = {88.5, 89.0, 89.5, 90.0, 90.5, 91.0};
        Radio radio = new Radio(radioFrequencies);//把数组放到遍历器中，将遍历器放到收音机（创建迭代器的工厂）中。
        ExtendedIterator<Double> iterator = radio.getIterator();

        System.out.println("=== 收音机频道遍历 ===");

        // 从第一个频率开始
        System.out.println("当前频率: " + iterator.getCurrent() + " MHz");
        radio.tuneToFrequency(iterator.getCurrent());

        // 向后遍历
        System.out.println("\n向后遍历:");
        while (iterator.hasNext()) {
            Double freq = iterator.next();
            System.out.println("下一个 → " + freq + " MHz");
            radio.tuneToFrequency(freq);
        }

        // 向前遍历
        System.out.println("\n向前遍历:");
        while (iterator.hasPrevious()) {
            Double freq = iterator.previous();
            System.out.println("上一个 ← " + freq + " MHz");
            radio.tuneToFrequency(freq);
        }
    }
}
