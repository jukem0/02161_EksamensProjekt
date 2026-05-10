#Lavet af Fabrizio
Feature: Budgetteret tid for aktivitet
    Description: Projektlederen kan under deres projekt bestemme den forventede antal arbejdstimer til aktiviteter

    Background:
        Given følgende medarbejdere findes i systemet:
            | medarbejder |
            | "huba"      |
            | "wilo"      |
            | "anda"      |

    Scenario Outline: Projektleder bestemmer budgetteret tid
        Given en <medarbejder> findes i systemet
        And at <medarbejder> er projektleder under <projektnavn>
        When medarbejderen bestemmer <budgetteret tid> til <aktivitetsnavn> som positivt decimaltal eller heltal, som slutter i <slut uge> og varer <uge antal>
        Then tildel <aktivitetsnavn> mængde af budgetteret tid rundet op til nærmeste halve

        Examples:
            | medarbejder | projektnavn | aktivitetsnavn | budgetteret tid | slut uge | uge antal |
            | "huba"      | "Website"   | "Design"       | 100             | 23       | 3         |
            | "wilo"      | "Rapport"   | "Indhold"      | 50.3            | 51       | 5         |
            | "anda"      | "Q1"        | "Presentation" | 50.2            | 12       | 2         |


    Scenario Outline: Projektleder angiver ikke budgetteret tid i decimaltal eller heltal
        Given at <medarbejder> er projektleder under <projektnavn>
        When medarbejderen bestemmer <budgetteret tid> til <aktivitetsnavn> som negativt decimaltal eller heltal, som slutter i <slut uge> og varer <uge antal>
        Then handling fejler med fejlbesked: "Budgetteret tid er ikke angivet som decimal- eller heltal"

        Examples:
            | medarbejder | projektnavn | aktivitetsnavn | budgetteret tid | slut uge | uge antal |
            | "huba"      | "Website"   | "Design"       | -100            | 23       | 3         |
            | "wilo"      | "Rapport"   | "Indhold"      | -50.3           | 51       | 5         |
            | "anda"      | "Q1"        | "Presentation" | -50.2           | 12       | 2         |
