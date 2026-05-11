# Project Manager

A terminal-based system to manage projects, activities, and time registration.

## How to Run
Navigate to the `manageprojects` folder and run:
```bash
mvn exec:java -Dexec.mainClass="com.projectmanager.app.Main"
```

## How to Use

### 1. Login
When prompted, log in using one of these usernames:
- `huba`
- `wilo`
- `anda`

### 2. Navigation
The system uses commands for navigation. Type a command and press Enter.

### Available Commands
- `help`: See help.
- `create_project <projectName>`: Create a new project.
- `create_activity <projectNr> <activityName>`: Add activity to a project.
- `assign_project_leader <projectName> <employeeName>`: Assign a leader.
- `add_employee_to_activity <employeeName> <activityName> <projectName>`: Assign employee to activity.
- `register_time <projectName> <activityName> <hours>`: Register your work hours.

## Running Tests
To run the Cucumber tests:
```bash
mvn test
```