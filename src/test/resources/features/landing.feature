@ui
Feature: Home Page Validation

	@login
	Scenario: Check landing page is loading or not

    Given browser is open
    When user clicks on login link
    Then user should be redirected to the login page
