package com.example.creational.factory_simple;

public class DoorFactory {

    /**
     * 创建一扇木门
     *
     * @param width  门的宽度
     * @param height 门的高度
     * @return Door 接口实例
     */
    public static Door createDoor(DoorType type, float width, float height) {
        switch (type) {
            case WOODEN:
                return new WoodenDoor(width, height);
            case GLASS:
                return new GlassDoor(width, height);
            case METAL:
                return new MetalDoor(width, height);
            default:
                throw new IllegalArgumentException("Unsupported door type: " + type);
        }
    }

    /**
     * 创建一扇标准尺寸的门（重载方法）
     *
     * @return Door 接口实例
     */
    public static Door createStandardDoor(DoorType type, float width, float height) {
        switch (type) {
            case WOODEN:
                return new WoodenDoor(80.0f, 200.0f);
            case GLASS:
                return new GlassDoor(80.0f, 200.0f);
            case METAL:
                return new MetalDoor(80.0f, 200.0f);
            default:
                throw new IllegalArgumentException("Unsupported door type: " + type);
        }
    }


}
