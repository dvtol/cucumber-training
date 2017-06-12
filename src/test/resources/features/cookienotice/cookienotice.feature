#language: nl
@CookieNotice
Functionaliteit: controleren cookie-melding Appie Today website

  Achtergrond: Feature: controleer cookie-melding
    Gegeven gebruiker is op Appie Today omgeving "tst"

  Scenario: 1 cookie-melding wordt gegeven voor een nieuwe gebruiker
    Gegeven de gebruiker heeft de cookies geaccepteert
    Dan toont de cookiemelding

  Scenario: 2 gebruiker accepteert cookies
    Gegeven de gebruiker heeft de cookies geaccepteert