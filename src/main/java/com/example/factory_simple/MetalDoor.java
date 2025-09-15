package com.example.factory_simple;

public class MetalDoor implements Door{
    private final float width;
    private final float height;

    public MetalDoor(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return String.format("WoodenDoor{width=%.2f, height=%.2f}", width, height);
    }
}
