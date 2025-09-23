package com.example.strucural.bridge.third;

public class AndroidNotification implements Notification{
    private NotificationPlatform platform;
    public AndroidNotification(NotificationPlatform platform) {
        this.platform = platform;
    }
    @Override
    public void send(String message) {
        // 桥接到Android具体实现
        platform.deliver(message);
    }
}
