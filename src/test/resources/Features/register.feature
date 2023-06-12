#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: User Registration
  As a user
  I want to register on the website
  So that I can access the member features

  @tagRegister
  Scenario: Successful registration
    Given I am on the login page
    When I click on the register button
    Then I should be redirected to the register page
    When I enter valid registration details
    And I click on the register button
    Then I should be redirected to the login page
    And I should see a success message

  @tagRegister
  Scenario: Registration with missing information
    Given I am on the registration page
    When I enter incomplete registration details
    And I click on the register button
    Then I should see error messages for the missing information
    And I should remain on the registration page

