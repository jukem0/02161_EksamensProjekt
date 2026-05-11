package com.projectmanager.commands;

//Gustav har lavet de flest commands
public abstract class Command {
    private String format;

    protected void setFormat(String format) {
        this.format = format;
    }

    protected String getFormat() {
        return format;
    }

    public String getName(){
        if (format == null || format.isEmpty()) {
            throw new IllegalStateException("Command format not set");
        }
        return format.split("[\\s]")[0];
    }

    public abstract void execute(String[] args);
}
