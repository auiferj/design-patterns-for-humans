package com.example.behavioral.command.second_undo_redo;

import java.util.ArrayList;
import java.util.List;

public class AdvancedRemoteControl {
    private List<TVCommand> history = new ArrayList<>();
    private int currentPosition = -1;

    public void executeCommand(TVCommand command) {
        // 执行新命令时，清除后面的重做历史
        if (currentPosition < history.size() - 1) {
            history = history.subList(0, currentPosition + 1);
        }

        command.execute();
        history.add(command);
        currentPosition++;
        System.out.println("命令已执行，历史记录: " + history.size() + " 条");
    }

    public void undo() {
        if (currentPosition >= 0) {
            TVCommand command = history.get(currentPosition);
            command.undo();
            currentPosition--;
            System.out.println("撤销完成，可重做命令: " + (history.size() - currentPosition - 1) + " 条");
        } else {
            System.out.println("没有可撤销的命令");
        }
    }

    public void redo() {
        if (currentPosition < history.size() - 1) {
            currentPosition++;
            TVCommand command = history.get(currentPosition);
            command.execute();
            System.out.println("重做完成，可重做命令: " + (history.size() - currentPosition - 1) + " 条");
        } else {
            System.out.println("没有可重做的命令");
        }
    }
}
