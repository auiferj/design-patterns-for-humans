package com.example.behavioral.chain_of_responsibility.third.interceptor;

import com.example.behavioral.chain_of_responsibility.third.command.Command;

public abstract class AbstractCommandInterceptor implements CommandInterceptor {

    protected CommandInterceptor next;

    @Override
    public void setNext(CommandInterceptor next) {
        this.next = next;
    }

    @Override
    public abstract <T> T execute(Command<T> command);
}
