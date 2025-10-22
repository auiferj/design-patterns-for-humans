package com.example.behavioral.iterator.first;

// 扩展的迭代器接口（继承标准迭代器思想，但添加getCurrent方法）
interface ExtendedIterator<T> extends Iterator<T> {
    T getCurrent();
}
