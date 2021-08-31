@am
Feature: Search functionality
  @sanity
  Scenario: Search feature with multiple tabs handling example
    Given browser is open
    When I navigate to url "https://www.amazon.in/"
    And Search for "Headphones" in the search bar
    And Save the URL of Headphones
    Then Open a new tab
  @popup
  Scenario: Popup test
    Given browser is open
    When I navigate to url "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html"
    And Click on demo button
    Then Select OK option
    
    
    
    
