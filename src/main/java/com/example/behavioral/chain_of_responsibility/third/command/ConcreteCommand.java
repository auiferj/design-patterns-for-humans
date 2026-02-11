package com.example.behavioral.chain_of_responsibility.third.command;

/**
 * concrete：具体的
 */
public class ConcreteCommand implements Command<String> {

    private String data;

    public ConcreteCommand(String data) {
        this.data = data;
    }

    @Override
    public String execute() {
        System.out.println("ConcreteCommand: Executing with data: " + data);
        return "Processed: " + data;
    }
}
