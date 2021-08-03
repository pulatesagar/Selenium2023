@ui
Feature: Home Page Validation

	@login
	Scenario: Check login page is loading or not

    Given browser is open
    And user should be redirected to the login page
