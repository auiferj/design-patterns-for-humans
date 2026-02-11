package com.example.behavioral.chain_of_responsibility.third.interceptor;

import com.example.behavioral.chain_of_responsibility.third.command.Command;

public interface CommandInterceptor {

    <T> T execute(Command<T> command);

    void setNext(CommandInterceptor next);
}
