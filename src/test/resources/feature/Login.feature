@mab
Feature: Successful Login
  Scenario Outline: User successfully logs in
    Given User is on the login page
    When User enters "<username>"
    Then User should be logged in successfully
    Examples:
      | username |
      | user1    |
      | user2    |