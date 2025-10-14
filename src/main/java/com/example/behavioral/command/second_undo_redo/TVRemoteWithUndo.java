package com.example.behavioral.command.second_undo_redo;

public class TVRemoteWithUndo {
    public static void main(String[] args) {
        Television tv = new Television();
        AdvancedRemoteControl remote = new AdvancedRemoteControl();

        System.out.println("=== 电视遥控器撤销重做演示 ===\n");

        // 开机
        remote.executeCommand(new TurnOnCommand(tv));

        // 切换频道
        remote.executeCommand(new ChangeChannelCommand(tv, 5));
        remote.executeCommand(new ChangeChannelCommand(tv, 8));

        // 调整音量
        remote.executeCommand(new AdjustVolumeCommand(tv, 15));
        remote.executeCommand(new AdjustVolumeCommand(tv, 20));

        System.out.println("\n--- 开始撤销操作 ---");
        // 撤销音量调整
        remote.undo(); // 撤销音量20→15
        remote.undo(); // 撤销音量15→10

        // 撤销频道切换
        remote.undo(); // 撤销频道8→5
        remote.undo(); // 撤销频道5→1

        System.out.println("\n--- 开始重做操作 ---");
        // 重做
        remote.redo(); // 重做频道1→5
        remote.redo(); // 重做频道5→8
        remote.redo(); // 重做音量10→15

        System.out.println("\n--- 混合操作 ---");
        remote.undo(); // 撤销音量15→10
        remote.executeCommand(new ChangeChannelCommand(tv, 12)); // 新命令，清除重做历史
        remote.undo(); // 撤销频道12→8
    }
}
