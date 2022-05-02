@Program
Feature: 

  To Validate login Functionality in Facebook App
Background:
    Given User have to enter fb Login page
    @Cucumber
  Scenario Outline: 
    
      To Valid Login by Using Valid Email and Password
    
    When user have to enter valid "<Email>" and "<Password>"
    And User have to click login button
    Then User have to be in invalid Credentials page

    Examples: 
      | Email                  | Password     |
      | Akash@gmail.com        |   9789411120 |
      | JavaSelenium@gmail.com | JavaSelenium |
      | Greens@gmail.com       | Greens@123   |
	@project
  Scenario: 
    To Valid Login by Using InValid Email and Password

    Given Maximize Browser Web page
    When user have to enter Invalid Email and Password
    And User have to click login button
    Then User have to be in invalid Credentials page
