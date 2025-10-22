package com.example.behavioral.memento.first;
// 发起人 - 文本编辑器
public class TextEditor {
    private String content;
    private int cursorPosition;
    private String fontStyle;

    public TextEditor() {
        this.content = "";
        this.cursorPosition = 0;
        this.fontStyle = "Normal";
    }

    public void type(String text) {
        this.content += text;
        this.cursorPosition += text.length();
        System.out.println("输入: '" + text + "' | 内容: " + content);
    }

    public void setFontStyle(String style) {
        this.fontStyle = style;
        System.out.println("字体样式改为: " + style);
    }

    public void setCursorPosition(int position) {
        this.cursorPosition = position;
        System.out.println("光标位置: " + position);
    }

    // 保存状态到备忘录
    public EditorMemento save() {
        System.out.println("💾 保存状态: '" + content + "' at position " + cursorPosition);
        return new EditorMemento(content, cursorPosition, fontStyle);
    }

    // 从备忘录恢复状态
    public void restore(EditorMemento memento) {
        this.content = memento.getContent();
        this.cursorPosition = memento.getCursorPosition();
        this.fontStyle = memento.getFontStyle();
        System.out.println("↩️ 恢复状态: '" + content + "' at position " + cursorPosition);
    }

    public void display() {
        System.out.println("当前状态: '" + content + "' | 光标: " + cursorPosition + " | 字体: " + fontStyle);
    }
}
