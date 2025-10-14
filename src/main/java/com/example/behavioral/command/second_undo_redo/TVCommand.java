package com.example.behavioral.command.second_undo_redo;

// Command（命令）接口
interface TVCommand {
    void execute();
    void undo();
}
