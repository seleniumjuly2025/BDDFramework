@PIM
  Feature: PIM - Add Employee Scenarios

    Background:
      Given User opens application
      When User logs in the username "Admin" and password "admin123"
      Then Dashbard should be visible
      Then User navigate to PIM Page
      Then User verify the PIM Page Header

      @Smoke @AddValidEmployee
      Scenario Outline: Add a new employee eith valid details
        When user clicks on Add Employee
        And user enters first name "<firstname>" and last name "<lastname>"
        And user sets employeeid "<empId>"
#        And user uploads photo "<photoPath>"
        And user clicks on Save button
        Then Successful employee creation toast should be visible
        Examples:
          | firstname | lastname | empId | photoPath                         |
          | Rahul     | Kumar    | 898   | /Users/akumar/Desktop/ironMan.png |
#          | Ashutosh  | Sharma   | 897   | /Users/akumar/Desktop/ironMan.png |
#          | Neha      | Patkar   | 896   | /Users/akumar/Desktop/ironMan.png |



