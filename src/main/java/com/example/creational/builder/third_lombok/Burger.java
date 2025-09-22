package com.example.creational.builder.third_lombok;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Burger {
    private final int size;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean lettuce;
    private final boolean tomato;
}
