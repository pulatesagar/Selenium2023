@ui
Feature: Login feature

  @validLogin
  Scenario Outline: Check login with valid credentials
    Given browser is open
    And user should be redirected to the login page
    When user enters <username> and <password>
    And user clicks on login button
    Then user should be redirected to dashboard

    Examples: 
      | username                      | password |
      | user|      123 |

  @invalidLogin
  Scenario Outline: Check login with invalid credentials
    Given browser is open
    And user should be redirected to the login page
    When user enters <username> and <password>
    And user clicks on login button
    Then It should show error message

    Examples: 
      | username                  | password |
      | user |     1234 |
