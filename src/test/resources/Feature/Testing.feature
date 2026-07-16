@Loginpage
Feature: To Verify Hotelbooker Login Webpage

  Background:
    Given open the browser and launch the application

  Scenario Outline: To verify Hotelbooker Login Webpage
    Given user should be in adactin login page
    When user should enter the "<Username>" and "<Password>"
    Then user clicks the login button
    And user should verify login successful message

    Then user should select the client "<ClientName>" and verify the client name

    Examples:
      | Username          | Password     | ClientName   |
      | deepanraj@test   | Deepan@1234  | Demo Client Sabre   |
