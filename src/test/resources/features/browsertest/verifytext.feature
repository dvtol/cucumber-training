@Smoketest

Feature: User wants to verify text on the page
  AC 1: The user should be able to visit the training page
  AC 2: The user should be able to verify checks after actions made
  AC 3: There should be an error message shown if the user verifies text which isn't displayed on the page

  Scenario: 1 User verifies text on the page
    Given the user visits the training login page
    Then the user is verifying text "LET OP!!" on the page with id "letop"
    And the user is verifying text "!!DIT IS EEN DEMO INLOG PAGINA VOOR DE Fitnesse / Cucumber Training!!" on the page with id "letop2"
    And the user clicks the verklaring button
    And the user is verifying text "Selecteer deze optie als u verbinding maakt op een openbare computer. Vergeet niet om u aan het einde van de sessie af te melden en alle browservensters te sluiten." on the page with id "info1"
    And the user is verifying text "Selecteer deze optie als u de enige bent die deze computer gebruikt. Met deze optie is een langere periode van inactiviteit toegestaan voordat u automatisch wordt afgemeld." on the page with id "info2"
    And the user clicks the second radiobutton
    And the user is verifying text "Waarschuwing: door deze optie te selecteren, bevestigt u dat de computer voldoet aan het beveiligingsbeleid van uw organisatie." on the page with id "letop3"
    And the user checks the checkbox
    And the user is verifying text "Als deze optie is geselecteerd, verschijnt een pagina waarop u uw wachtwoord kunt wijzigen nadat u uw referenties hebt ingediend." on the page with id "wwaaninfo"