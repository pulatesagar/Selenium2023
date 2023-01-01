$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/File1.feature");
formatter.feature({
  "name": "ToolsQA",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@toolsqa"
    }
  ]
});
formatter.scenario({
  "name": "Demo of multiple windows",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@toolsqa"
    },
    {
      "name": "@windows"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "browser is open",
  "keyword": "Given "
});
formatter.match({
  "location": "LandingStepDefs.browser_is_open()"
});
formatter.write("Chrome Driver invoked and URL navigated as: https://www.google.com/");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to url \"https://demoqa.com/browser-windows\"",
  "keyword": "When "
});
formatter.match({
  "location": "LandingStepDefs.i_navigate_to_url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on New Window button",
  "keyword": "And "
});
formatter.match({
  "location": "LandingStepDefs.i_click_on_New_Window_button()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Browser is Closed");
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Demo of Iframes",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@toolsqa"
    },
    {
      "name": "@iframes"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "browser is open",
  "keyword": "Given "
});
formatter.match({
  "location": "LandingStepDefs.browser_is_open()"
});
formatter.write("Chrome Driver invoked and URL navigated as: https://www.google.com/");
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to url \"https://demoqa.com/frames\"",
  "keyword": "When "
});
formatter.match({
  "location": "LandingStepDefs.i_navigate_to_url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I switch to frame",
  "keyword": "And "
});
formatter.match({
  "location": "LandingStepDefs.i_switch_to_frame()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Browser is Closed");
formatter.after({
  "status": "passed"
});
});