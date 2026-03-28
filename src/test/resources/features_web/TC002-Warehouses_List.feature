Feature: 1-1-TC-01-Sample CREATION -
  This Feature file is used to create Sample.

  Background: User log in to Application
    Given User launches app "ACC" Environment


#  @Warehouse_Creation @End_to_End
  Scenario Outline: Validate Creation Of the Warehouse
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "Add Warehouse" in Items list
    And User Enter Warehouse name"<WarehouseName>" and Location"<Loction>"
    When User Clicks on "<button>" in Wakanda Books
    Then User Validate the Warehouse in Warehouse List
    Examples:
      | role        | company      | Module | SubModule  | button        | WarehouseName | Loction |
      | Super Admin | Titan Deploy | Items  | Warehouses | Add Warehouse | TVK Warehouse | Chennai |

#  @Warehouse_Updation @End_to_End
  Scenario Outline: Validate Update Of the Warehouse
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on Action button in Warehouse list
    When User clicks on "<Actions>" and fill the details
    And User Enter Warehouse name"<WarehouseName>" and Location"<Loction>"
    When User Clicks on "<button>" in Wakanda Books
    Then User Validate the Warehouse in Warehouse List
    Examples:
      | role        | company      | Module | SubModule  | button           | WarehouseName | Loction | Actions |
      | Super Admin | Titan Deploy | Items  | Warehouses | Update Warehouse | TVK Warehouse | Munbai  | Edit    |

#  @Warehouse_Deletation @End_to_End
  Scenario Outline: Validate Delete Of the Warehouse
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on Action button in Warehouse list
    When User clicks on "<Actions>" Warehouse List
    When User Clicks on delete in Wakanda Books
    Then User validated deleted the message
    Examples:
      | role        | company      | Module | SubModule  | Actions |
      | Super Admin | Titan Deploy | Items  | Warehouses | Delete  |

#  @Warehouse_Add_Items @End_to_End
  Scenario Outline: Verify user can successfully add warehouse item
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on Action button in Warehouse list
    When User clicks on "<Actions>" Warehouse List
    When User clicks on "Add Items"
    And User selects item from "light"
    And User enters valid Opening Stock
    And User enters Selling Wholesale Price and Minimum Quantity
    When User Clicks on "<Button>" in Wakanda Books
    Then Item should be successfully added in warehouse list
    Examples:
      | role        | company      | Module | SubModule  | Actions | Button |
      | Super Admin | Titan Deploy | Items  | Warehouses | View    | Save   |


#  @Warehouse_Error_Message_Validation @End_to_End
  Scenario Outline: Validate Selling Price should not be less than average purchase price
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on Action button in Warehouse list
    When User clicks on "<Actions>" Warehouse List
    When  User Update Selling Price as less than average purchase price
    Then User should be able to see error message "Selling price cannot be less than the average purchase price"
    When  User Update Wholesale Price as less than average purchase price
    Then User should be able to see error message "Wholesale price cannot be less than the average purchase price"
    Examples:
      | role        | company      | Module | SubModule  | Actions | Button |
      | Super Admin | Titan Deploy | Items  | Warehouses | View    | Save   |


