Feature: 1-1-TC-01-Sample CREATION -
  This Feature file is used to create Sample.

  Background: User log in to Application
    Given User launches app "ACC" Environment

  @Checking @Regression @SmokeTest @HealthCheck
  Scenario Outline: Valaidate Creation Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "Add Product" in Items list
    And User add "", "" and "" details in add products
    And User add price details "" and "" in Additional Information
    And User select "<Warehouse>" details and Information details
    When User Clicks on "<button>" in Wakanda Books
#    Then User Validate the Product in Items List

    Examples:
      | role        | company   | Module | SubModule  | Warehouse   | button |
      | Super Admin | wsolution | Items  | Items List | ABC - Stock | Save   |