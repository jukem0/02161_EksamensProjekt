#Lavet af Fabrizio
Feature: tildele medarbejder til en aktivitet
    Description: medarbejdere i systemet kan tildeles aktiviteter under projekter

  Background:
    Given følgende medarbejdere findes i systemet:
      | medarbejder |
      | "huba"      |
      | "ambe"      |
      | "joni"      |

  Scenario Outline: tildel medarbejder en aktivitet
    Given der findes en aktivitet med navn <aktivitetsnavn> i projektet <projektnavn>
    And en <medarbejder> findes i systemet
    When en medarbedjer udpeger en anden medarbejder <medarbjeder> til at være tilknyttet aktivitet med navn <aktivitetsnavn>
    Then tildel medarbejder <medarbjeder> til aktivitet med navn <aktivitetsnavn> skal lykkes

    Examples:
      | medarbjeder | aktivitetsnavn |projektnavn|
      | "ambe"      | "Design"       |"fuckCucumber"|

  Scenario Outline: medarbejder er allerede tildelt aktivitet
    Given der findes en aktivitet med navn <aktivitetsnavn> i projektet <medarbjeder>
    When en medarbedjer udpeger en anden medarbejder <medarbjeder> til at være tilknyttet aktivitet med navn <aktivitetsnavn>
    And medarbejder <medarbjeder> allerede er tildelt aktivitet med navn <aktivitetsnavn>
    Then handling fejler med fejlbesked: "Medarbejder er allerede tildelt denne aktivitet"

    Examples:
      | medarbjeder | aktivitetsnavn |
      | "ambe"      | "Design"       |
