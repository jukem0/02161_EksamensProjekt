package com.projectmanager.commands;

import com.projectmanager.services.RuntimeContext;

public class AddActivityToProjectCommand extends Command {

    @Override
    public String getName() {
        return "add_activity";
    }

    @Override
    public void execute(String[] args) {
        // Expected format: add_activity <projectNr> <activityName> : <projectLeader>
        if (args.length >= 2) {
            String projectNr = args[0];
            String activityName = args[1];
            String projectLeader = args[2];

            com.projectmanager.model.Project project = RuntimeContext.getProjects().stream()
                    .filter(p -> p.getProjectNr().equals(projectNr))
                    .findFirst().orElse(null);

            com.projectmanager.model.Employee leader = RuntimeContext.getEmployees().stream()
                    .filter(e -> e.getEmployeeName().equalsIgnoreCase(projectLeader))
                    .findFirst().orElse(null);

            if (project == null) {
                System.out.println("Project " + projectNr + " not found");
                return;
            }

            com.projectmanager.model.Employee currentUser = RuntimeContext.getCurrentUser();
            if (currentUser == null) {
                System.out.println("No user logged in");
                return;
            }

            try {
                com.projectmanager.services.EmployeesFunctions.addActivityToProject(activityName, project, currentUser);
                System.out.println("Created " + activityName + " in project " + projectNr);
            } catch (Exception e) {
                System.out.println("Error");
            }
        } else {
            System.out.println(
                    "Syntax Error. Expectet format: create_activity <projectNr> <activityName> : <projectLeader>");
        }
    }
}
