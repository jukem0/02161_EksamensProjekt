package com.projectmanager.commands;

import com.projectmanager.services.Parser;
import com.projectmanager.services.RuntimeContext;

public class CreateProjectCommand extends Command{
    private Parser parser;

    public CreateProjectCommand(RuntimeContext context){
        parser = new Parser(context);
    }

    @Override
    public String getName() {
        return "create_project";
    }

    @Override
    public void execute(String[] args) {
        //Expected format: create_project <projectName> : <newLeaderName>
        //args should only contain the part after inital command. Everything after ":" is optional
        if (args.length == 1) {
            
        } else if (args.length == 2) {
            
        } 
    }

    
}
