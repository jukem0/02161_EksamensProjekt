package com.projectmanager.commands;

import com.projectmanager.services.Parser;

public abstract class Command {
    private Parser parser;
    private String format;
    public String getName(){
        return format.split("[ ]")[0];
    }
    public abstract void execute(String[] args);
}
