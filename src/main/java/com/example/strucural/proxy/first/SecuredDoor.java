package com.example.strucural.proxy.first;
// 3. 代理类 - 在基本功能上添加安全控制
public class SecuredDoor {
    private Door door;

    public SecuredDoor(Door door) {
        this.door = door;
    }

    public void open(String password) {
        if (authenticate(password)) {
            door.open();  // 调用原始功能
        } else {
            System.out.println("访问被拒绝！密码错误");
        }
    }

    public void openWithCard(String cardNumber) {
        if (validateCard(cardNumber)) {
            door.open();  // 调用原始功能
        } else {
            System.out.println("门禁卡无效！");
        }
    }

    public void openWithButton() {
        System.out.println("使用安全绕过按钮开门");
        door.open();  // 调用原始功能
    }

    private boolean authenticate(String password) {
        return "secret".equals(password);
    }

    private boolean validateCard(String cardNumber) {
        return cardNumber.startsWith("ACME-");
    }

    public void close() {
        door.close();
    }
}
