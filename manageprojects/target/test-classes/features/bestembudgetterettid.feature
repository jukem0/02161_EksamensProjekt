Feature: Budgetteret tid for aktivitet
    Beskrivelse: Projektlederen kan under deres projekt bestemme den forventede antal arbejdstimer til aktiviteter


    Background: 
    Given følgende medarbejdere findes i systemet:
        |medarbejder  |
        |"huba"       |
        |"ambe"       |
        |"joni"       |

    Scenario: Projektleder bestemmer budgetteret tid
    Given en <medarbejder> findes i systemet
    And at <medarbejder> er projektleder under <projektnavn>
    When <medarbejder> bestemmer budgetteret tid til <aktivitetsnavn> som positivt decimaltal eller heltal
    Then tildel <aktivitetsnavn> mængde af budgetteret tid rundet op til nærmeste halve

    Scenario: Projektleder angiver ikke budgetteret tid i decimaltal eller heltal
    Given at <medarbejder> er projektleder under <projektnavn>
    When <medarbejder> bestemmer budgetteret tid, <budgetterettid>, til <aktivitetsnavn> som andet end decimal- eller heltal
    Then handling fejler med fejlbesked: "Budgetteret tid er ikke angivet som decimal- eller heltal"