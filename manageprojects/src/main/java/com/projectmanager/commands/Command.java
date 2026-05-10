package com.projectmanager.commands;

public abstract class Command {
    public abstract String getName();
    public abstract void execute(String[] args);
}
