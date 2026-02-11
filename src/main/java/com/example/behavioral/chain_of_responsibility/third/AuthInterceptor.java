package com.example.behavioral.chain_of_responsibility.third;

import com.example.behavioral.chain_of_responsibility.third.command.Command;
import com.example.behavioral.chain_of_responsibility.third.interceptor.AbstractCommandInterceptor;

public class AuthInterceptor extends AbstractCommandInterceptor {

    @Override
    public <T> T execute(Command<T> command) {
        System.out.println("AuthInterceptor: Performing authentication check for command: " + command.getClass().getSimpleName());
        // In a real scenario, authentication logic would go here.
        // For this demo, we'll just pass it along.
        T result = next.execute(command);
        System.out.println("AuthInterceptor: Authentication check complete for command: " + command.getClass().getSimpleName());
        return result;
    }
}
