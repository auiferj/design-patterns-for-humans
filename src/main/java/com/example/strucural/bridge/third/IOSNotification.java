package com.example.strucural.bridge.third;

public class IOSNotification implements Notification {
    private NotificationPlatform platform;
    public IOSNotification(NotificationPlatform platform) {
        this.platform = platform;
    }
    @Override
    public void send(String message) {
        // 桥接到iOS具体实现
        platform.deliver(message);
    }
}
