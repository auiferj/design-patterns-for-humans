package com.example.strucural.flyweight.demo_2;

import java.util.HashMap;
import java.util.Map;

// 享元工厂
public class ColorFactory {
    private static Map<String, ChessPieceColor> colors = new HashMap<>();

    public static ChessPieceColor getColor(String color) {
        if (!colors.containsKey(color)) {
            colors.put(color, new ChessPieceColor(color));
        }
        return colors.get(color);
    }

    public static int getColorCount() {
        return colors.size();
    }
}
