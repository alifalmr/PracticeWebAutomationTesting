@Test
Feature: Testing Log In Page as a User

  @MainTest @Positive
  Scenario Outline: User log in with valid email and password
    Given User navigates to the log in page
    When User log in with "almiraalifa@gmail.com" as an email and "coBac0ba" as a password
    And User should be directed to home page
    And User input "<keyword>" as a keyword submit it to search
    And User should be directed to search result
    And User go to the second search result
    Then User should be on the news page
  Examples:
    | keyword |
    |pilpres|
    |bogor  |


  @Positive
  Scenario: User log in with valid email and password
    Given User navigates to the log in page
    When User log in with "almiraalifa@gmail.com" as an email and "coBac0ba" as a password
    Then User should be directed to home page

  @Negative
  Scenario Outline: User log in with invalid credentials
    Given User navigates to the log in page
    When User log in with "<email>" as an email and "<password>" as a password
    Then User should get an error message
  Examples:
    |email|password|
    |aaa@gmail.com| hjel34|
    |iwiwi@hhh.com|22222  |

  @Positive
  Scenario: User activates view password
    Given User navigates to the log in page
    When User clicks view password button
    Then User should see the password

  @Positive1 @Positive
  Scenario: User signs up a new account
    Given User navigates to the log in page
    When User clicks sign up button
    Then User should be directed to the sign up page

  @Positive
  Scenario: User goes to forgot password page
    Given User navigates to the log in page
    When User clicks lupa password button
    Then User should be directed to forgot password page

  @Positive
  Scenario: User goes back to the home page
    Given User navigates to the log in page
    When User clicks go back button
    Then User should be directed to home page