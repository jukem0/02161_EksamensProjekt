Feature: Create Project
  Description: The user creates a project
  Actors: Huba

# create
Scenario: create project with no initial projectLeader
  Given that the employees "HuBa" have avaible time
  And there is a project with name "test", employees "Huba", projectLeader Null, activities "activity1"+"activity2"
  And the project is not in the projectManager
  When Project "test" is created
  Then the project with name "test",employees "Huba", projectLeader Null, activities "activity1"+"activity2" is contained in the projectManager


Scenario: create project with initial projectLeader
Scenario: projects name already excists

Scenario: Make an activity
Scenario: assign projectleader
Scenario: add employees to activities //see which are avalible
Scenario: plan the start/stop for activities