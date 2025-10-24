@Login
 Feature: Login and Dashboard Verification

   Background:
     Given User opens application

   @ValidLogin @Smoke
   Scenario: Valid login should show Dashboard
     When User logs in the username "Admin" and password "admin123"
     Then Dashbard should be visible

   @Regression @InvalidLogin
   Scenario Outline: Login with Invalid Credentials
     When User logs in the username "<username>" and password "<password>"
     And User clicks on Login Btn
     Then error message "<errorMessage>" should be displayed
     Examples:
       | username | password | errorMessage        |
       | Admin    | wrong123 | Invalid credentials |
       | wronguser| admin123 | Invalid credentials |
       | wronguser| wrong123 | Invalid credentials |
     
     @Sanity
     Scenario Outline: Login with blank username
       When User logs in the username "<username>" and password "<password>"
       And User clicks on Login Btn
       Then error message "<errorMessage>" should be displayed on field
       Examples:
         | username | password | errorMessage|
         |          | admin123 | Required    |
         | Admin.   |          | Required    |
