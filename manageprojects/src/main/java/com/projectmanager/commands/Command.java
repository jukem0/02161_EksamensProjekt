package com.projectmanager.commands;

import com.projectmanager.services.Parser;

public abstract class Command {
    private Parser parser;
    public abstract String getName();
    public abstract void execute(String[] args);
}
