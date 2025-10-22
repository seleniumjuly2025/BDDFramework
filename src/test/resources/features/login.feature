@Login
 Feature: Login and Dashboard Verification

   @ValidLogin
   Scenario: Valid login should show Dashboard
     Given User opens application
     When User logs in the username "Admin" and password "admin123"
     Then Dashbard should be visible