package com.example.strucural.bridge.first.page;

import com.example.strucural.bridge.first.them.Theme;

/**
 * career：经历，职业生涯
 */
public class Careers implements WebPage{
    protected Theme theme;

    public Careers(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "Careers page in " + this.theme.getColor();
    }
}
