@NewRegistrationExtraOptionsCommissary

Feature: Add and remove extra commissary scenarios - OR frontoffice

  Background: Feature: Extra scenario's OR frontoffice - new registration

    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Besloten Vennootschap"
    And within "Besloten Vennootschap" the user enters the unique "Naam_rechtspersoon" with "B.V."
    And within "Besloten Vennootschap" the user enters the "Zetel" with "Woerden"
    And within "Besloten Vennootschap" the user enters the "Datum_akte_van_oprichting" with "01-01-2018"
    And within "Besloten Vennootschap" the user enters the "Datum_ingang" with "01-01-2018"
    Then click on the Volgende button
    And within "Kapitaalgegevens" the user enters the "Geplaatst_kapitaal" with "2000"
    And within "Kapitaalgegevens" the user enters the "Gestort_kapitaal" with "1000"
    Then click on the Volgende button
    And within "Bestuurder(s)" the user enters the "Datum_waarop_de_functionaris_in_functie_is_getreden" with "01-01-2018"
    And within "Bestuurder(s)" the user enters the "Burgerservicenummer" with "999916464"
    And the user clicks checkbox to validate the BSN number
    Then click on the Volgende button
    Then click on the Volgende button
    Then click on the Volgende button
    And within "Gemachtigde(n)" the user chooses for "question" the radiobutton "Ja"

  Scenario: Add extra commissary with legal type BV
    Then click Add extra group button

  Scenario: Delete extra added commissary with legal type BV
    Then click Add extra group button
    And click on the Delete button

  Scenario: Select commissary with type proxy in use of legal type BV
    And within "Gemachtigde(n)" the user enters the "Datum_waarop_de_gemachtigde_in_functie_is_getreden" with "01-01-2018"
    And within "Gemachtigde(n)" the user chooses for "Type_gemachtigde" the option "Gevolmachtigde"

  Scenario: Select commissary with type commercial agent in use of legal type BV
    And within "Gemachtigde(n)" the user enters the "Datum_waarop_de_gemachtigde_in_functie_is_getreden" with "01-01-2018"
    And within "Gemachtigde(n)" the user chooses for "Type_gemachtigde" the option "Handelsagent"
