package com.example.behavioral.strategy.first;

public class StrategyPatternExample {
    public static void main(String[] args) {
        int[] smallDataset = {1, 3, 4, 2};
        int[] mediumDataset = {1, 4, 3, 2, 8, 10};
        int[] bigDataset = {1, 4, 3, 2, 8, 10, 5, 6, 9, 7, 15, 12, 11};

        Sorter sorter = new Sorter(new BubbleSortStrategy(), new QuickSortStrategy(),5);

        System.out.println("\n1. 小数据集排序:");
        sorter.sort(smallDataset);
        printArray(smallDataset);

        System.out.println("\n2. 中数据集排序:");
        sorter.sort(mediumDataset);
        printArray(mediumDataset);

        System.out.println("\n3. 大数据集排序:");
        sorter.sort(bigDataset);
        printArray(bigDataset);

        // 动态切换策略
        System.out.println("\n=== 动态切换策略 ===");
        sorter.setSmallDataStrategy(new QuickSortStrategy());
        sorter.setLargeDataStrategy(new MergeSortStrategy());
        sorter.setThreshold(8);

        System.out.println("切换后的小数据集排序:");
        sorter.sort(smallDataset);

        System.out.println("切换后的中数据集排序:");
        sorter.sort(mediumDataset);

        System.out.println("切换后的大数据集排序:");
        sorter.sort(bigDataset);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
