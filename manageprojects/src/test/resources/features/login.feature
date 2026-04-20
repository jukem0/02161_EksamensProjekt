# Lavet af Alexander
Feature: Logger ind

Scenario: Personen logges ind
    Given medarbejderen har initialerne "huba"
    When når medarbejderen prøver at logge ind
    Then medarbejderen logges ind

Scenario: Personen findes ikke og logges derved ikke ind
    Given medarbejderen har initialerne "uau"
    When når medarbejderen prøver at logge ind
    Then medarbejderen findes ikke og logges derved ikke ind og får beskeden "Bruger findes ikke."