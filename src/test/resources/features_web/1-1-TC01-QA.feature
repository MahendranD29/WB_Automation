Feature: 1-1-TC-01-Sample CREATION -
  This Feature file is used to create Sample.

  Background: User log in to Application
    Given User launches app "ACC" Environment

  @Checking @Regression @SmokeTest @HealthCheck
  Scenario Outline: Checking
    When User clicks on "<check>" in Dashboard
    Examples:
      | check |
      | abc   |