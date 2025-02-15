Feature: Login Functionality for OpenCart E-commerce Website

  As a user of the OpenCart website
  I want to be able to log in with my account
  So that I can access my account-related features and manage my orders

  Background:
    Given I am on the OpenCart login page

  Scenario: Successful login with valid email and password
    Given I have entered a valid email address and password
    When I click on the login button
    Then I should be logged in successfully


  Scenario Outline: Unsuccessful login with invalid email or password
    Given I have entered invalid "<email>" and "<password>"
    When I click on the login button
    Then I should see an error message containing "<error_message>"

    Examples:
      | email            | password             | error_message                                         |
      | qasdet@gail.com  | invalid1235          | Warning: No match for E-Mail Address and/or Password. |
      | abcccc@test.com  | validPassword        | Warning: No match for E-Mail Address and/or Password. |
      | validt@gmail.com | abc23cc              | Warning: No match for E-Mail Address and/or Password. |
      | qadev@gmail.com  | password with spaces | Warning: No match for E-Mail Address and/or Password. |
