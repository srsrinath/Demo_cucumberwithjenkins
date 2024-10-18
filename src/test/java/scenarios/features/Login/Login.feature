#@test
Feature: Checking the  Login functionality
  @test
Scenario Outline:  Verify if user is able to login with valid credentials
    Given Log In to DMS
    Then User clicks submit button.
Examples:
  |demo1|
  |demo |



#  Scenario Outline:  Verify if user is able to login with invalid credentials
#    Given Log into the Koovers with Invalid credentials.
#    Then User click on the submit button.
#
#    Examples:
#      |demo1|
#      |demo |
#
# Scenario Outline: Verify if the user is able to submit form without entering data
#     Given User enter into welcome screen
#     Then User clicks on submit button.
#   Examples:
#     |demo1|
#     |demo |
#
# Scenario Outline: Verify whether the User is able to Login into account using same browser Twice.
#     Given Log into the Koovers with valid credentials by open another tab
#     Then User click the  submit button.
#   Examples:
#     |demo1|
#     |demo |