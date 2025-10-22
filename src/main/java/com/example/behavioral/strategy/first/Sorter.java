package com.example.behavioral.strategy.first;

// 排序器 - 根据数据大小选择合适的策略
class Sorter {
    private SortStrategy smallDataStrategy;
    private SortStrategy largeDataStrategy;
    private int threshold;

    public Sorter(SortStrategy smallDataStrategy, SortStrategy largeDataStrategy, int threshold) {
        this.smallDataStrategy = smallDataStrategy;
        this.largeDataStrategy = largeDataStrategy;
        this.threshold = threshold;
    }

    public Sorter(SortStrategy smallDataStrategy, SortStrategy largeDataStrategy) {
        this(smallDataStrategy, largeDataStrategy, 5); // 默认阈值
    }

    public int[] sort(int[] dataset) {
        System.out.println("数据集大小: " + dataset.length + ", 阈值: " + threshold);
        if (dataset.length > threshold) {
            return largeDataStrategy.sort(dataset);
        } else {
            return smallDataStrategy.sort(dataset);
        }
    }

    // 动态切换策略的方法
    public void setSmallDataStrategy(SortStrategy strategy) {
        this.smallDataStrategy = strategy;
    }

    public void setLargeDataStrategy(SortStrategy strategy) {
        this.largeDataStrategy = strategy;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
