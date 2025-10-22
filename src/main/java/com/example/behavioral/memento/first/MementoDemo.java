package com.example.behavioral.memento.first;

import java.util.Stack;

// 使用示例
class MementoDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        HistoryManager history = new HistoryManager();

        // 初始状态
        history.saveState(editor.save());

        System.out.println("=== 编辑过程 ===");
        editor.type("Hello");
        history.saveState(editor.save());

        editor.type(" World");
        history.saveState(editor.save());

        editor.setFontStyle("Bold");
        history.saveState(editor.save());

        editor.type("!");
        history.saveState(editor.save());

        editor.display();
        history.showHistory();

        System.out.println("\n=== 撤销操作 ===");
        editor.restore(history.undo()); // 撤销最后一个"!"
        editor.restore(history.undo()); // 撤销字体更改
        editor.restore(history.undo()); // 撤销" World"

        editor.display();
    }
}
