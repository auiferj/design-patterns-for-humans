package com.example.behavioral.memento.first;

import java.util.Stack;
import java.util.concurrent.BlockingDeque;

// 管理者 - 负责管理备忘录历史
class HistoryManager {
    /**
     * Stack继承自Vector，虽然线程安全（synchronized），在不需要线程安全的场景下带来不必要的性能开销
     * 使用Deque代替Stack
     */
    private Stack<EditorMemento> history = new Stack<>();

    public void saveState(EditorMemento memento) {
        history.push(memento);
        System.out.println("📚 历史记录保存，总数: " + history.size());
    }

    public EditorMemento undo() {
        if (history.size() > 1) {
            history.pop(); // 移除当前状态
            EditorMemento previous = history.peek();
            System.out.println("⏪ 撤销到历史记录");
            return previous;
        } else {
            System.out.println("❌ 无法撤销，已在最初状态");
            return history.peek();
        }
    }

    public void showHistory() {
        System.out.println("=== 编辑历史 ===");
        for (int i = 0; i < history.size(); i++) {
            EditorMemento memento = history.get(i);
            System.out.println("[" + i + "] '" + memento.getContent() + "'");
        }
    }
}
