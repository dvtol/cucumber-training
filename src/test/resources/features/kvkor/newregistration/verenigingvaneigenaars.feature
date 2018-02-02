@NewRegistrationVvE
Feature: OR frontoffice login

  Background: Feature: OR frontoffice login

  Scenario: Registration Vereniging van Eigenaars
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Vereniging van Eigenaars"
    And within "Basisgegevens van de Vereniging van Eigenaars" the user enters the unique "Naam_rechtspersoon" with "VvE"
    And within "Basisgegevens van de Vereniging van Eigenaars" the user enters the "Zetel" with "Utrecht"
    And within "Basisgegevens van de Vereniging van Eigenaars" the user enters the "Datum_akte_van_oprichting" with "01-01-2018"
    And within "Basisgegevens van de Vereniging van Eigenaars" the user enters the "Datum_ingang" with "01-01-2018"
    Then click on the Volgende button
    And within "Adresgegevens rechtspersoon" the user enters the "Postcode" with "3447GT"
    And within "Adresgegevens rechtspersoon" the user enters the "Huisnummer" with "1"
    And within "Adresgegevens rechtspersoon" the user chooses for "isPostAdresGelijkAanBezoekAdres" the radiobutton "Nee"
    And within "Adresgegevens rechtspersoon" the user enters the "Postcode" with "3447GT"
    And within "Adresgegevens rechtspersoon" the user enters the "Huisnummer" with "1"
    And within "Adresgegevens rechtspersoon" the user enters the "Activiteitomschrijving" with "Dit is een activiteitomschrijving 12313"
    Then click on the Opslaan button
    Then click on the Volgende button
    And within "Bestuurder(s)" the user enters the "Datum_waarop_de_functionaris_in_functie_is_getreden" with "01-01-2018"
    And within "Bestuurder(s)" the user enters the "Burgerservicenummer" with "999916464"
    And the user clicks checkbox to validate the BSN number
    Then click on the Volgende button
    Then click on the Volgende button
    Then click on the Volgende button
    And within "Bijlage(n)" the user uploads the attachment "Datacard.pdf" for "Datacard Vanya Ebben (verplicht)"
    And within "Bijlage(n)" the user uploads the attachment "Authentiek afschrift.pdf" for "Authentiek afschrift(splitsingsakte, statuten eventueel met (model)regelement) (verplicht)"
    Then click on the Opslaan button
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

