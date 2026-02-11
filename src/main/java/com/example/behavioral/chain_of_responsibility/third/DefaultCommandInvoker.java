package com.example.behavioral.chain_of_responsibility.third;

import com.example.behavioral.chain_of_responsibility.third.command.Command;
import com.example.behavioral.chain_of_responsibility.third.interceptor.AbstractCommandInterceptor;

public class DefaultCommandInvoker extends AbstractCommandInterceptor {

    @Override
    public <T> T execute(Command<T> command) {
        System.out.println("Executing command: " + command.getClass().getSimpleName());
        return command.execute();
    }
}
