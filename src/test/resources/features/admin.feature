@AdminRole

  Feature: Verify Admin User Management Functionality

#    Background:
#      Given User opens application
#      When User logs in the username "Admin" and password "admin123"
#      Then Dashbard should be visible
#      Then User navigate to Admin Page

    @SearchUser @Sanity @Smoke
      Scenario Outline: Verify searching user by username
      When user enters username "<username>" in search field
      And User click on Search button
      Then User record with "<username>" should be displayed
      Examples:
        |   username         |
        |  adrian1748        |
        |  adrian2804        |
        |  adrian3307        |
        |  adrian5077        |




