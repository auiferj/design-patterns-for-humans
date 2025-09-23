package com.example.strucural.bridge.first;

import com.example.strucural.bridge.first.page.About;
import com.example.strucural.bridge.first.page.Careers;
import com.example.strucural.bridge.first.page.WebPage;
import com.example.strucural.bridge.first.them.*;

public class BridgePatternExample {
    public static void main(String[] args) {
        Theme darkTheme = new DarkTheme();

        WebPage about = new About(darkTheme);
        WebPage careers = new Careers(darkTheme);

        System.out.println(about.getContent()); // "About page in Dark Black"
        System.out.println(careers.getContent()); // "Careers page in Dark Black"

        // 可以轻松切换主题
        Theme lightTheme = new LightTheme();
        WebPage aboutLight = new About(lightTheme);
        System.out.println(aboutLight.getContent()); // "About page in Off white"

        Theme aquaTheme = new AquaTheme();
        WebPage careersAqua = new Careers(aquaTheme);
        System.out.println(careersAqua.getContent()); // "Careers page in Light blue"
    }
}
