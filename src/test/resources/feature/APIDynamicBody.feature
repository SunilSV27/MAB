Feature: Dynamic body

  Scenario Outline: Call the POST API with dynamic body
    Given I have a dynamic request body "<eqpnum>"
    When I make a POST request to the API endpoint
    Then the API responds with a success status code
    Examples:
      | eqpnum |
      | 001    |
      | 002    |