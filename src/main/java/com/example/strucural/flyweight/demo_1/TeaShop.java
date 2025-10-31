package com.example.strucural.flyweight.demo_1;

import java.util.HashMap;
import java.util.Map;

public class TeaShop {
    private Map<String, TeaType> teaTypes = new HashMap<>();

    public TeaType getTeaType(String name) {
        TeaType tea = teaTypes.get(name);
        if (tea == null) {
            // 如果还没有这种茶，就创建并保存（相当于煮一壶新茶）
            switch(name) {
                case "红茶":
                    tea = new TeaType("红茶", "红茶配方");
                    break;
                case "绿茶":
                    tea = new TeaType("绿茶", "绿茶配方");
                    break;
            }
            teaTypes.put(name, tea);
            System.out.println("煮了一壶新的: " + name);
        }
        return tea;
    }
}
