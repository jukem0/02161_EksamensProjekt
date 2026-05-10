#Lavet af Fabrizio
Feature: Tider for aktiviteter
    Description: Projektlederen bestemmer start- og sluttid for aktiviteter i projekter

    Background:
        Given følgende medarbejdere findes i systemet:
            | medarbejder |
            | "huba"      |
            | "ambe"      |
            | "joni"      |

    Scenario Outline: Projektleder bestemmer tider for aktiviteter
        Given en <medarbejder> findes i systemet
        And at <medarbejder> er projektleder under <projektnavn>
        And <aktivitet> er findes i systemet
        When <medarbejder> bestemmer slutdato, (<uge>, <aar>), og <antaluger> for aktiviteten <aktivitet>
        And tildeler <aktivitetsnavn> slutdatoen, <slutdato>, og <antaluger> uger som værende afgrænsede tid for færdiggørelse af projekt
        Then kan <aktivitetsnavn> findes under projektet med slutdatoen, <slutdato>, og <antaluger> uger

    Scenario Outline: Projektleder angiver en negativ ugemængde
        Given at <medarbejder> er projektleder under <projektnavn>
        And <aktivitet> er findes i systemet
        When <medarbejder> bestemmer slutdato, (<uge>, <aar>), og <antaluger> for aktiviteten <aktivitet>
        But <ugemængde> er negativ
        Then handling fejler med fejlbesked: <fejlbesked>

        Examples:
            | medarbejder | projektnavn | aktivitetsnavn | startdato    | slutdato     |
            | "huba"      | "Website"   | "Design"       | "2023-01-01" | "2023-01-31" |
