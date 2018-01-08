#language: nl
@NieuweInschrijving
Functionaliteit: OR frontoffice inlog

  Achtergrond: Feature: OR frontoffice inlog
    Gegeven dat gebruiker is ingelogd op de OR pagina van de KvK

  Scenario: Inschrijving Besloten Vennootschap
    Als de gebruiker voor een nieuwe inschrijving kiest met een type rechtsvorm "Besloten Vennootschap"
    En de benodigde en verplichte gegevens zijn opgevoerd
    Dan kan de gebruiker de opgave valideren, ondertekenen en indienen

  Scenario: Inschrijving Vereniging van Eigenaars
    Als de gebruiker voor een nieuwe inschrijving kiest met een type rechtsvorm "Vereniging van Eigenaars"
