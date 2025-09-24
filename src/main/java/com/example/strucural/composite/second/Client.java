package com.example.strucural.composite.second;
// 客户端使用
public class Client {
    public static void main(String[] args) {
        File file1 = new File("文档1.txt");
        File file2 = new File("图片.png");

        Directory subDir = new Directory("子文件夹");
        subDir.addComponent(new File("秘密文件.pdf"));

        Directory rootDir = new Directory("根目录");
        rootDir.addComponent(file1);
        rootDir.addComponent(file2);
        rootDir.addComponent(subDir);

        // 统一对待文件和文件夹
        rootDir.showInfo("");
    }
}
