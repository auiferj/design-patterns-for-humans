package com.example.behavioral.iterator.first;

// 标准迭代器接口，支持双向遍历，符合收音机的使用习惯
interface Iterator<T> {
    boolean hasNext();
    T next();
    boolean hasPrevious();
    T previous();
    //提供重置功能，方便重新开始
    void reset();
}
