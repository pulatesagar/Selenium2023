@toolsqa
Feature: ToolsQA

  @windows
  Scenario: Demo of multiple windows
    Given browser is open
    When I navigate to url "https://demoqa.com/browser-windows"
    And I click on New Window button

  @iframes
  Scenario: Demo of Iframes
    Given browser is open
    When I navigate to url "https://demoqa.com/frames"
    And I switch to frame
