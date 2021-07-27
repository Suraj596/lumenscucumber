$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Lumens.feature");
formatter.feature({
  "line": 1,
  "name": "Lumens.com Application TestCases (End to End validation)",
  "description": "",
  "id": "lumens.com-application-testcases-(end-to-end-validation)",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "TC001 Account Creation",
  "description": "",
  "id": "lumens.com-application-testcases-(end-to-end-validation);tc001-account-creation",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@createaccount"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user should open link",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "click on accountand enter credentials \"\u003cSheetName\u003e\" and \"\u003cRowNumber\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "click on submit",
  "keyword": "And "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "lumens.com-application-testcases-(end-to-end-validation);tc001-account-creation;",
  "rows": [
    {
      "cells": [
        "SheetName",
        "RowNumber"
      ],
      "line": 10,
      "id": "lumens.com-application-testcases-(end-to-end-validation);tc001-account-creation;;1"
    },
    {
      "cells": [
        "CreateAccount",
        "3"
      ],
      "line": 11,
      "id": "lumens.com-application-testcases-(end-to-end-validation);tc001-account-creation;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3116745,
  "status": "passed"
});
formatter.before({
  "duration": 8040829503,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "TC001 Account Creation",
  "description": "",
  "id": "lumens.com-application-testcases-(end-to-end-validation);tc001-account-creation;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@createaccount"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user should open link",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "click on accountand enter credentials \"CreateAccount\" and \"3\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "click on submit",
  "keyword": "And "
});
formatter.match({
  "location": "LumensStepsTest.user_should_open_link()"
});
formatter.result({
  "duration": 50296478327,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "CreateAccount",
      "offset": 39
    },
    {
      "val": "3",
      "offset": 59
    }
  ],
  "location": "LumensStepsTest.click_on_accountand_enter_credentials_and(String,int)"
});
formatter.result({
  "duration": 13477001239,
  "status": "passed"
});
formatter.match({
  "location": "LumensStepsTest.click_on_submit()"
});
formatter.result({
  "duration": 5119754942,
  "status": "passed"
});
formatter.after({
  "duration": 329416,
  "status": "passed"
});
formatter.after({
  "duration": 1215814413,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 14,
  "name": "TC002 Login and TC003 Verify Title",
  "description": "",
  "id": "lumens.com-application-testcases-(end-to-end-validation);tc002-login-and-tc003-verify-title",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@loginandtitle"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "User should nagivate to url",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "User able to give credentials \"\u003cSheetName\u003e\" and \"\u003cRowNumber\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Click on login button",
  "keyword": "And "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "lumens.com-application-testcases-(end-to-end-validation);tc002-login-and-tc003-verify-title;",
  "rows": [
    {
      "cells": [
        "SheetName",
        "RowNumber"
      ],
      "line": 20,
      "id": "lumens.com-application-testcases-(end-to-end-validation);tc002-login-and-tc003-verify-title;;1"
    },
    {
      "cells": [
        "CreateAccount",
        "2"
      ],
      "line": 21,
      "id": "lumens.com-application-testcases-(end-to-end-validation);tc002-login-and-tc003-verify-title;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1182769,
  "status": "passed"
});
