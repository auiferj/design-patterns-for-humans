package com.example.behavioral.command.first_undo_redo;
// Command（命令）接口
public interface Command {
    void execute();
    void undo();
}
