package com.example.behavioral.memento.first;
// 备忘录 - 存储编辑器状态
public class EditorMemento {
    private final String content;
    private final int cursorPosition;
    private final String fontStyle;

    public EditorMemento(String content, int cursorPosition, String fontStyle) {
        this.content = content;
        this.cursorPosition = cursorPosition;
        this.fontStyle = fontStyle;
    }

    public String getContent() { return content; }
    public int getCursorPosition() { return cursorPosition; }
    public String getFontStyle() { return fontStyle; }
}
