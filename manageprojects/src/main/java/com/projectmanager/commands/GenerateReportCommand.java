package com.projectmanager.commands;

import com.projectmanager.model.Project;
import com.projectmanager.services.Parser;
import com.projectmanager.services.ProjectsFunctions;

public class GenerateReportCommand extends Command{

    public GenerateReportCommand() {
        setFormat("generate_report <projectName> <weekNr>");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 2) {
            Project project = Parser.stringToProject(args[0]);
            int weekNr = Integer.parseInt(args[1]);
            ProjectsFunctions.makeReport(project, weekNr);
        }
    }
    
    
}
