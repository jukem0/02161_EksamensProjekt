#Lavet af Fabrizio
Feature: Tider for aktiviteter
    Description: Projektlederen bestemmer start- og sluttid for aktiviteter i projekter

    Background: 
   
    Given følgende medarbejdere findes i systemet:
        |medarbejder  |
        |"huba"       |
        |"ambe"       |
        |"joni"       |

    Scenario Outline: Projektleder bestemmer tider for aktiviteter
    Given en <medarbejder> findes i systemet
    And at <medarbejder> er projektleder under <projektnavn>
    When <medarbejder> bestemmer start- og sluttid til <aktivitetsnavn> som datoer <startdato>, <slutdato>
    Then tildel <aktivitetsnavn> datoerne, <startdato> og <slutdato> som værende afgrænsede tid for færdiggørelse af projekt

    Scenario Outline: Projektleder angiver startdato senere end slutdato
    Given at <medarbejder> er projektleder under <projektnavn>
    When <medarbejder> bestemmer start- og sluttid til <aktivitetsnavn> som datoer <startdato>, <slutdato>
    And <startdato> er senere end <slutdato>
    Then handling fejler med fejlbesked: "Startdato kan ikke være efter slutdato"

    Examples: 
        | medarbejder | projektnavn | aktivitetsnavn | startdato | slutdato |
        | "huba"      | "Website"   | "Design"       | "2023-01-01" | "2023-01-31" |