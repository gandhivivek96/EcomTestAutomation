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

#
#  Scenario Outline: Unsuccessful login with invalid email or password
#    Given I have entered invalid "<email>" and "<password>"
#    When I click on the login button
#    Then I should see an error message containing "<error_message>"
#
#    Examples:
#      | email             | password         | error_message                                        |
#      | invalid@email.com | invalidPassword  | Warning: No match for E-Mail Address and/or Password. |
#      | abcccc            | validPassword    | Warning: No match for E-Mail Address and/or Password. |
#      | valid@email.com   | abccc            | Warning: No match for E-Mail Address and/or Password. |
#     # |                   |                  | Warning: No match for E-Mail Address and/or Password. | #Empty credentials
#      #| valid@email.com   | password with spaces | Warning: No match for E-Mail Address and/or Password. | #Whitespace
#
#  Scenario: Navigating to the forgotten password page
#    When I click on the "Forgotten Password" link
#    Then I should be redirected to the password reset page #at "/index.php?route=account/forgotten" # Or the actual URL
