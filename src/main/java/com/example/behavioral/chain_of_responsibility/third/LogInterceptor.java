package com.example.behavioral.chain_of_responsibility.third;

import com.example.behavioral.chain_of_responsibility.third.command.Command;
import com.example.behavioral.chain_of_responsibility.third.interceptor.AbstractCommandInterceptor;

public class LogInterceptor extends AbstractCommandInterceptor {

    @Override
    public <T> T execute(Command<T> command) {
        System.out.println("LogInterceptor: Before executing command: " + command.getClass().getSimpleName());
        T result = next.execute(command);
        System.out.println("LogInterceptor: After executing command: " + command.getClass().getSimpleName());
        return result;
    }
}
