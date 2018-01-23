@NewRegistrationRio
Feature: OR frontoffice login

  Background: Feature: OR frontoffice login

  Scenario: Registration Rechtspersoon in oprichting
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Rechtspersoon in oprichting"
    And within "Basisgegevens van de Rechtspersoon in oprichting" the user enters the "Datum_ingang" with "01-01-2018"
    And within "Basisgegevens van de Rechtspersoon in oprichting" the user chooses for "Doelrechtsvorm" the option "Naamloze Vennootschap"
    Then click on the Volgende button
    And within "Bevoegd functionarissen" the user enters the "Datum_waarop_de_functionaris_in_functie_is_getreden" with "01-01-2018"
    And within "Bevoegd functionarissen" the user enters the "Burgerservicenummer" with "999916464"
    And the user clicks checkbox to validate the BSN number
    Then click on the Opslaan button
    Then click on the Volgende button
    And within "Vestiging(en)" the user enters the "Datum_ingang" with "01-01-2018"
    And within "Vestiging(en)" the user chooses for "isBezoekAdresBuitenlandsAdres" the radiobutton "Nee"
    And within "Vestiging(en)" the user enters the "Postcode" with "1061tl"
    And within "Vestiging(en)" the user enters the Huisnummer with "17"
    And within "Vestiging(en)" the user enters the "Toevoeging_adres" with "AB"
    And within "Vestiging(en)" the user chooses for "isPostAdresGelijkAanBezoekAdres" the radiobutton "Ja"
    And within "Vestiging(en)" the user enters the "Activiteitomschrijving" with "Dit is een activiteitomschrijving"
    And within "Vestiging(en)" the user enters the "Indien_meerdere_activiteiten,_wat_is_dan_de_belangrijkste?" with "Dit is belangrijk"
    And within "Vestiging(en)" the user chooses for "importeer" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "exporteer" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for Activiteit "1" the option "01134 - Teelt van aardappels en overige wortel- en knolgewassen"
    And within "Vestiging(en)" the user chooses for Activiteit "2" the option "4615 - Handelsbemiddeling in meubels, huishoudelijke artikelen en ijzerwaren"
    And within "Vestiging(en)" the user chooses for "Wat_is_de_hoofdactiviteit?" the option "01134 - Teelt van aardappels en overige wortel- en knolgewassen"
    And within "Vestiging(en)" the user chooses for "inEenWinkelOfKiosk" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "opDeMarkt" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "viaStraathandel" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "viaInternet" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "vanuitHuis" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "perPostorder" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "andersNamelijk" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "verkoopAanGroothandel" the radiobutton "Nee"
    And within "Vestiging(en)" the user enters the unique "deletableHandelsnaam_1_*_" with "N.V."
    And within "Vestiging(en)" the user chooses for "hasDomeinnamen" the radiobutton "Nee"
    And within "Vestiging(en)" the user chooses for "hasEmailadressen" the radiobutton "Nee"
    And within "Vestiging(en)" the user enters the "Hoeveel_personen_werken_er_fulltime_(15_uur_of_meer_per_week)_in_de_onderneming?" with "2"
    And within "Vestiging(en)" the user enters the "Hoeveel_personen_werken_er_parttime_(minder_dan_15_uur_per_week)_in_de_onderneming?" with "2"
    Then click on the Opslaan button
    Then click on the Volgende button
    Then click on the Volgende button
    And within "Bijlage(n)" the user uploads the attachment "Datacard.pdf" for "Datacard Vanya Ebben (verplicht)"
    Then click on the Volgende button
    And within "Referentie informatie" the user enters the Naam_berichtenbox with "123"
    And within "Referentie informatie" the user chooses for "uitsluiten" the radiobutton "Nee"
    And within "Referentie informatie" the user chooses for "uitlenen" the radiobutton "Nee"
    And within "Referentie informatie" the user chooses for "uitreksel" the radiobutton "Nee"
    And within "Referentie informatie" the user chooses for "engelsUittreksel" the radiobutton "Nee"
    And within "Referentie informatie" the user enters the "Naam_contactpersoon" with "Simon de Tester"
    And within "Referentie informatie" the user enters the "E-mailadres_contactpersoon" with "noreply@kvk.nl"
    And within "Referentie informatie" the user enters the "Telefoonnummer_contactpersoon" with "0612345678"
    And within "Referentie informatie" the user enters the "Uw_referentie" with "referentie"
    And within "Referentie informatie" the user enters the "Aanvullende_informatie" with "Aanvullende informatie"
    Then click on the Opslaan button
    Then click on the Volgende button
    Then click on the Valideren button
    Then the message Validate is succesvol is shown