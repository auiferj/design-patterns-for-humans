package com.example.behavioral.strategy.first;

// 冒泡排序策略
class BubbleSortStrategy implements SortStrategy {
    @Override
    public int[] sort(int[] dataset) {
        System.out.println("Sorting using bubble sort");

        // 实际的冒泡排序实现
        int n = dataset.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (dataset[j] > dataset[j + 1]) {
                    // 交换元素
                    int temp = dataset[j];
                    dataset[j] = dataset[j + 1];
                    dataset[j + 1] = temp;
                }
            }
        }
        return dataset;
    }
}
