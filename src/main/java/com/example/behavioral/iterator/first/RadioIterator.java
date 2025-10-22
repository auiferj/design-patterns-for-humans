package com.example.behavioral.iterator.first;

/**
 * 具体迭代器实现（收音机）
 * 负责管理频率数组的遍历逻辑
 */
class RadioIterator implements ExtendedIterator<Double> {
    private double[] frequencies;
    private int currentPosition;

    /**
     * 构造函数
     * @param frequencies 频率数组，要求非空且至少有一个元素
     */
    public RadioIterator(double[] frequencies) {
        this.frequencies = frequencies;
        this.currentPosition = 0;
    }

    public boolean hasNext() {
        return currentPosition < frequencies.length - 1;
    }

    public Double next() {
        if (hasNext()) {
            currentPosition++;
            return frequencies[currentPosition];
        }
        return null;
    }

    public boolean hasPrevious() {
        return currentPosition > 0;
    }

    public Double previous() {
        if (hasPrevious()) {
            currentPosition--;
            return frequencies[currentPosition];
        }
        return null;
    }

    public void reset() {
        currentPosition = 0;
    }

    public Double getCurrent() {
        return frequencies[currentPosition];
    }
}
