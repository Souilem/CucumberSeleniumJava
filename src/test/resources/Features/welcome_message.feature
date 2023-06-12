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

Feature: Welcome Message
  As a user
  I want to see a welcome message with the authenticated username
  So that I know that I am logged in successfully

  Scenario: Display welcome message with the authenticated username
    Given I am on the home page
    When I log in with username "user1" and password "password1"
    Then I should see a welcome message with the username "user1"