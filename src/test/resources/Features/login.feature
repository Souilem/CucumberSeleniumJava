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
Feature: User Login
  As a user
  I want to be able to log in and log out to the website
  So that I can access my account

  @tagLogin
  Scenario: Successful login
    Given I am on the login page
    When I enter my username "user6" and password "user6"
    And I click on the login button
    Then I should be redirected to the home page
    And I should see a welcome message with the username "user6"
    When I click on the logout button
    Then I should be redirected to the home page
    And I should not see a welcome message with the username "user6"
    

  @tagLogin
  Scenario: Invalid login
  	 Given I am on the login page
  	 When I enter an invalid username "userInvalid1" and password "userInvalid1"
     And I click on the login button
     Then I should see an error message
     And I should remain on the login page
     
     
  @tagPassword
 	Scenario: forgot password
 		Given I am on the login page, I forgot my password
 		When I enter an invalid username "userInvalid1" or password "userInvalid1"
 		And I click on the Forgot password button
 		Then I shoud be redirected to the Password recovery Forms page
 		And enter a valid email "user6@gmail.com"
 		Then I click on the recover button
 		Then I should be redirected to the Password recovery page
 		And I enter a newPassword "user6" and confirmedNewPassword "user6"
 		And I click on the submit button
 		Then I should see a notification Password updated successfully
 		And be redirected to the log-in page