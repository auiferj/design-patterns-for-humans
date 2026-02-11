package com.example.behavioral.chain_of_responsibility.third;

import com.example.behavioral.chain_of_responsibility.third.command.Command;
import com.example.behavioral.chain_of_responsibility.third.command.ConcreteCommand;
import com.example.behavioral.chain_of_responsibility.third.interceptor.CommandInterceptor;

public class ZApp {
    public static void main(String[] args) {
        // Build the chain of responsibility
        DefaultCommandInvoker invoker = new DefaultCommandInvoker();

        AuthInterceptor authInterceptor = new AuthInterceptor();
        authInterceptor.setNext(invoker);

        LogInterceptor logInterceptor = new LogInterceptor();
        logInterceptor.setNext(authInterceptor);

        // The entry point of our chain
        CommandInterceptor firstInterceptor = logInterceptor;

        // Create a command
        Command<String> myCommand = new ConcreteCommand("User data for processing");

        // Execute the command through the chain
        String result = firstInterceptor.execute(myCommand);
        System.out.println("Application received result: " + result);

        System.out.println("\n--- Executing another command ---");
        Command<String> anotherCommand = new ConcreteCommand("Another piece of data");
        String anotherResult = firstInterceptor.execute(anotherCommand);
        System.out.println("Application received another result: " + anotherResult);
    }
}
