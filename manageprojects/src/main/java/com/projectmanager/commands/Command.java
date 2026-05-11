package com.projectmanager.commands;

public abstract class Command {
    private String format;
    public String getName(){
        return format.split("[ ]")[0];
    }
    public abstract void execute(String[] args);
}
