#language: nl
@NieuweInschrijving
Functionaliteit: OR frontoffice inlog

  Achtergrond: Feature: OR frontoffice inlog
    Gegeven dat gebruiker is ingelogd op de OR pagina van de KvK

  Scenario: Inschrijving Besloten Venootschap
    Als de gebruiker voor een nieuwe inschrijving kiest met een type rechtsvorm
    En de benodigde en verplichte gegevens zijn opgevoerd
    Dan kan de gebruiker de opgave valideren, ondertekenen en indienen

  Scenario: Inschrijving Vereniging van Eigenaren
    Als de gebruiker voor een nieuwe inschrijving kiest met een type rechtsvorm
