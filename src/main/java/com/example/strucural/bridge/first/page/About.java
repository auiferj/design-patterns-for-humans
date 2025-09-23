package com.example.strucural.bridge.first.page;

import com.example.strucural.bridge.first.them.Theme;

// 具体网页实现
public class About implements WebPage{
    protected Theme theme;

    public About(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "About page in " + this.theme.getColor();
    }
}
