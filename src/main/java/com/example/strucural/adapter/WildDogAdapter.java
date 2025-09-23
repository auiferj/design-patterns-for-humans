package com.example.strucural.adapter;
// 适配器：让 WildDog 能够像 Lion 一样工作
public class WildDogAdapter implements Lion{
    private WildDog dog;

    // 适配器内部包含一个需要被适配的对象
    public WildDogAdapter(WildDog dog) {
        this.dog = dog;
    }

    @Override
    public void roar() {
        // 将 roar() 调用“翻译”成 WildDog 的 bark() 行为
        dog.bark();
    }

    @Override
    public void hunt() {
        // 将 hunt() 调用“翻译”成 WildDog 的 chase() 行为
        dog.chase();
    }
}
