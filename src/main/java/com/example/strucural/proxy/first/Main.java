package com.example.strucural.proxy.first;
// 4. 使用示例
public class Main {
    public static void main(String[] args) {
        // 创建带安全代理的门
        SecuredDoor securedDoor = new SecuredDoor(new LabDoor());

        // 尝试不同的开门方式
        securedDoor.open("wrong");        // 访问被拒绝！密码错误
        securedDoor.open("secret");       // 打开实验室的门

        securedDoor.openWithCard("INVALID"); // 门禁卡无效！
        securedDoor.openWithCard("ACME-123"); // 打开实验室的门

        securedDoor.openWithButton();     // 使用安全绕过按钮开门
        // 打开实验室的门
    }
}
