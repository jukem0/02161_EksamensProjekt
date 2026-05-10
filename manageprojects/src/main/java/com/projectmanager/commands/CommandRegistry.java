package com.projectmanager.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandRegistry(List<Command> commandList){
        for (Command c : commandList) {
            commands.put(c.getName(), c);
        }
    }

    public Command findCommand(String commandName){
        return commands.get(commandName);
    }
}
