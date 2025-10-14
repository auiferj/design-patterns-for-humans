package com.example.behavioral.command.second;

// Client（客户） - 你
public class TVClient {
    public static void main(String[] args) {
        Television tv = new Television();           // 接收者
        RemoteControl remote = new RemoteControl(); // 调用者

        // 开机
        TVCommand turnOn = new TurnOnCommand(tv);
        remote.setCommand(turnOn);
        remote.pressButton(); // 电视机：开机

        // 换台
        TVCommand changeTo5 = new ChangeChannelCommand(tv, 5);
        remote.setCommand(changeTo5);
        remote.pressButton(); // 电视机：切换到频道 5
    }
}
