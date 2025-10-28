# Orange-HRM BDD

Automation Framework using Cucumber BDD Approach

## Execute the Test

Install maven
and Install allure report


```bash
 mvn clean test -Dcucumber.filter.tags="@Login" && allure generate allure-results --clean -o allure-report && allure open allure-report
```
