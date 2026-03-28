Feature: 1-1-TC-01-Sample CREATION -
  This Feature file is used to create Sample.

  Background: User log in to Application
    Given User launches app "ACC" Environment

     @Warehouse_Creation @End_to_End @Sanity
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

# @Product_Creation @End_to_End @Sanity
  Scenario Outline: Validate Creation Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "Add Product" in Items list
    And User Field as "Product" and add Values "Blutooth", "PC","piece","Test" details
    And User add Additional "<Vendor>" Information details
    And User select "<Warehouse>" details and Information details
    When User Clicks on "<button>" in Wakanda Books
    Then User Validate the in Items List
    Then User Validate the Item in Full validation
    When User clicks on "<Actions>" and fill the details
    When User fill the update details
    When User Clicks on "<button>" in Wakanda Books
    Then User validated updated the message
    When User clicks on "<Action>" and fill the details
    When User Clicks on delete in Wakanda Books
    Then User validated deleted the message
    When User Clicks on deleted List
    Then User validated deleted Item
    When User Restore the deleted item
    Then User Validate the Restore the item

    Examples:
      | role        | company      | Module | SubModule        | Warehouse     | button | Actions | Action | Vendor  |
      | Super Admin | Titan Deploy | Items  | Items Management | TVK Warehouse | Save   | Edit    | Delete | bharath |


#  @Product_Creation1 @End_to_End
  Scenario Outline: Validate Creation Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "Add Product" in Items list
    And User Field as "Product" and add Values "Biskets", "PC","piece","Electronic" details
    And User add Additional "<Vendor>" Information details
    And User select "<Warehouse>" details and Information details
    When User Clicks on "<button>" in Wakanda Books
    Then User Validate the in Items List
    Then User Validate the Item in Full validation
    Examples:
      | role        | company      | Module | SubModule        | Warehouse    | button | Vendor |
      | Super Admin | Titan Deploy | Items  | Items Management | AK Warehouse | Save   | maahi  |

#      @Product_Creation1 @End_to_End
  Scenario Outline: Validate Creation Of the Product in Transaction Table
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "Add Product" in Items list
    And User Field as "Product" and add Values "Biskets", "PC","piece","Electronic" details
    And User add Additional "<Vendor>" Information details
    And User select "<Warehouse>" details and Information details
    When User Clicks on "<button>" in Wakanda Books
    When User Clicks on Transaction Tab in Item details
    Then User Validate the in Transaction List
#    Then User Validate the Item in Full validation
    Examples:
      | role        | company      | Module | SubModule        | Warehouse    | button | Vendor |
      | Super Admin | Titan Deploy | Items  | Items Management | AK Warehouse | Save   | maahi  |


#  @Product_Creation1 @End_to_End @Sanity
  Scenario Outline: Validate product creation with warehouse details
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "Add Product" in Items list
    And User Field as "Product" and add Values "Paper Cup", "PC","piece","Electronic" details
    And User add Additional "<Vendor>" Information details
    And User select "<Warehouse>" details and Information details
    When User Clicks on "<button>" in Wakanda Books
    Then User Validate the in Items List
    Then User Validate the Item in Full validation
    Then User Validate the "<Warehouse>" in Item details
    Examples:
      | role        | company      | Module | SubModule        | Warehouse     | button | Vendor |
      | Super Admin | Titan Deploy | Items  | Items Management | TVK Warehouse | Save   | maahi  |

#  @Product_Creation1 @End_to_End
  Scenario Outline: Verify error when adding duplicate product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "Add Product" in Items list
    And User Field as "Product" and add Values "Paper Cup", "PC","piece","Electronic" details
    And User add Additional "<Vendor>" Information details
    And User select "<Warehouse>" details and Information details
    When User Clicks on "<button>" in Wakanda Books
    Then User Validate the error message "An item with the same name already exists."
    Examples:
      | role        | company      | Module | SubModule        | Warehouse     | button | Vendor |
      | Super Admin | Titan Deploy | Items  | Items Management | TVK Warehouse | Save   | maahi  |

#  @Price_Validation @End_to_End
  Scenario Outline: Verify error when retail price is less than purchase price
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "Add Product" in Items list
    And User Field as "Product" and add Values "Paper Cup", "PC","piece","Electronic" details
    And User add Additional "<Vendor>" Information details
    And User select the "<Warehouse>" and enter selling price less than purchase price details
    Then Error message should be displayed "Retail price cannot be less than purchase price"

    Examples:
      | role        | company      | Module | SubModule        | Warehouse | Vendor |
      | Super Admin | Titan Deploy | Items  | Items Management |           | maahi  |

#  @Price_Validation @End_to_End
  Scenario Outline: Verify error when retail price is less than purchase price
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "Add Product" in Items list
    And User Field as "Product" and add Values "Paper Cup", "PC","piece","Electronic" details
    And User add Additional "<Vendor>" Information details
    And User select the "<Warehouse>" and enter Wholesale price less than purchase price details
    Then Error message should be displayed "Wholesale price cannot be less than purchase price"

    Examples:
      | role        | company      | Module | SubModule        | Warehouse     | Vendor |
      | Super Admin | Titan Deploy | Items  | Items Management | TVK Warehouse | maahi  |

# @Product_Search_Action1 @End_to_End
  Scenario Outline: Verify user is able to search product using Product Name and Ref ID
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User enters product name "Paper Cup" in search field
    Then Product with name "Paper Cup" should be displayed in the list
    When User enters product ref id in search field
    Then Product with ref id should be displayed in the list

    Examples:
      | role        | company      | Module | SubModule        |
      | Super Admin | Titan Deploy | Items  | Items Management |

#  @Product_invalid search_Action1 @End_to_End
  Scenario Outline: Verify no result message for invalid search
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User enters product name "500 ml Water BottleA" in search field
    Then No product should be displayed and user should see message "No results found for your search."

    Examples:
      | role        | company      | Module | SubModule        |
      | Super Admin | Titan Deploy | Items  | Items Management |

#  @Product_Category_Filter @End_to_End
  Scenario Outline: Verify user can filter products by category
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on category filter
    When User Search the category "Test" in category filter
    When User selects category "Test"
    Then Only products from category "Test" should be displayed

    Examples:
      | role        | company      | Module | SubModule        |
      | Super Admin | Titan Deploy | Items  | Items Management |

#  @Product_Category_Filter @End_to_End
  Scenario Outline: Verify search works within selected category
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on category filter
    When User Search the category "Test" in category filter
    When User selects category "Test"
    And User enters product name "PVC Light" in search field
    Then Product "PVC Light" should be displayed under "Test"

    Examples:
      | role        | company      | Module | SubModule        |
      | Super Admin | Titan Deploy | Items  | Items Management |

#  @Product_Category_Filter @End_to_End
  Scenario Outline: Verify product not displayed for wrong category
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on category filter
    When User Search the category "Test" in category filter
    When User selects category "Test"
    And User enters product name "Super" in search field
    Then No product should be displayed and user should see message "No results found for your search."

    Examples:
      | role        | company      | Module | SubModule        |
      | Super Admin | Titan Deploy | Items  | Items Management |

#  @Service_Creation @End_to_End
  Scenario Outline: Validate View Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    Then User Validate the View Page


    Examples:
      | role        | company      | Module | SubModule        | Actions | Button  |
      | Super Admin | Titan Deploy | Items  | Items Management | View    | Product |

  #@Product_Update @TC002 @End_to_End
  Scenario Outline: Validate Update Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "<Actions>" and fill the details
    When User fill the update details
    When User Clicks on "<button>" in Wakanda Books
    Then User validated updated the message
    Examples:
      | role        | company      | Module | SubModule        | Actions | button |
      | Super Admin | Titan Deploy | Items  | Items Management | Edit    | Save   |

#  @Product_Delete @End_to_End
  Scenario Outline: Validate Delete Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "<Actions>" and fill the details
    When User Clicks on delete in Wakanda Books
    Then User validated deleted the message
    Examples:
      | role        | company      | Module | SubModule        | Actions |
      | Super Admin | Titan Deploy | Items  | Items Management | Delete  |

#  @Product_Restore @End_to_End
  Scenario Outline: Validate Deleted Of the Product Restore
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Clicks on deleted List
    Then User validated deleted Item
    When User Restore the deleted item
    Then User Validate the Restore the item
    Examples:
      | role        | company      | Module | SubModule        | Actions |
      | Super Admin | Titan Deploy | Items  | Items Management | Delete  |

#  @Product_filed_Validation @End_to_End
  Scenario Outline: Validate product creation with empty mandatory fields
    When User login on "<role>" in Wakanda Books
    And User select "<company>" on login page
    And User clicks on "<Module>" and Select "<SubModule>"
    And User clicks on "Add Product" in Items list
    And User enter "Product" details with name "<ProductName>" unit "<Unit>" and category "<Category>"
    When User Clicks on "<button>" in Wakanda Books
    Then User should see validation message "<ErrorMessage>" and product should not be created

    Examples:
      | role        | company   | Module | SubModule  | ProductName | Unit | Category | button | ErrorMessage         |
      | Super Admin | wsolution | Items  | Items List |             | KG   | Grocery  | Save   | Name is required     |
      | Super Admin | wsolution | Items  | Items List | Raise       |      | Grocery  | Save   | Unit is required     |
      | Super Admin | wsolution | Items  | Items List | Raise       | KG   |          | Save   | Category is required |

#  @Service_Creation @End_to_End
  Scenario Outline: Validate Creation Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    Then User Validate the list before "<Service>" Creation in service
    When User clicks on "Add Service" in Items list
    Then User Validate the list before "<Service>" Creation in service
    And User Field as "Service" and add Values "<Service>", "H","Hour","Electronics Service" details
    And User add price details and in Additional Information
    When User Clicks on "<button>" in Wakanda Books
    Then User Validate the in Service List
#    Then User Validate the Item in Full validation
    When User clicks on "<Actions>" and fill the details
    When User fill the update details in Service
    When User Clicks on "<button>" in Wakanda Books
    Then User validated updated the message in Service
    When User clicks on "<Action>" and fill the details
    When User Clicks on delete in Wakanda Books
    Then User validated deleted the message
    When User Clicks on deleted List
    Then User validated deleted Item
    When User Restore the deleted item
    Then User Validate the Restore the item

    Examples:
      | role        | company      | Module | SubModule        | Button  | button | Actions | Action | Service        |
      | Super Admin | Titan Deploy | Items  | Items Management | Service | Save   | Edit    | Delete | Manaul Testing |

#  @Service_Creation @End_to_End
  Scenario Outline: Validate Creation Of the Service
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    Then User Validate the list before "<Service>" Creation in service
    When User clicks on "Add Service" in Items list
    And User Field as "Service" and add Values "Manual Testing", "H","Hour","Electronics Service" details
    And User add price details and in Additional Information
    When User Clicks on "<Save>" in Wakanda Books
    Then User Validate the in Items List

    Examples:
      | role        | company      | Module | SubModule        | Button  | Save | Service        |
      | Super Admin | Titan Deploy | Items  | Items Management | Service | Save | Manual Testing |

#  @Service_Search_Action @End_to_End
  Scenario Outline: Verify user is able to search product using Product Name and Ref ID
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User enters product name "Manual Testing" in search field
    Then Product with name "Manual Testing" should be displayed in the list
    When User enters product ref id in search field
    Then Product with ref id should be displayed in the list

    Examples:
      | role        | company      | Module | SubModule        | Button  |
      | Super Admin | Titan Deploy | Items  | Items Management | Service |

#      @Service_invalid_search_Action1 @End_to_End
  Scenario Outline: Verify no result message for invalid search
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User enters product name "500 ml Water BottleA" in search field
    Then No product should be displayed and user should see message "No results found for your search."

    Examples:
      | role        | company      | Module | SubModule        |Button  |
      | Super Admin | Titan Deploy | Items  | Items Management |Service |

#      @Service_Category_Filter @End_to_End
  Scenario Outline: Verify user can filter products by category
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on category filter
    When User Search the category "Testing" in category filter
    When User selects category "Testing"
    Then Only products from category "Testing" should be displayed

    Examples:
      | role        | company      | Module | SubModule        |Button  |
      | Super Admin | Titan Deploy | Items  | Items Management |Service |

#  @Service_Category_Filter @End_to_End
  Scenario Outline: Verify search works within selected category
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on category filter
    When User Search the category "Testing" in category filter
    When User selects category "Testing"
    And User enters product name "Manual Testing" in search field
    Then Product "Manual Testing" should be displayed under "Testing"

    Examples:
      | role        | company      | Module | SubModule        |Button  |
      | Super Admin | Titan Deploy | Items  | Items Management |Service |

#  @Service_Category_Filter @End_to_End
  Scenario Outline: Verify product not displayed for wrong category
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on category filter
    When User Search the category "Testing" in category filter
    When User selects category "Testing"
    And User enters product name "Super" in search field
    Then No product should be displayed and user should see message "No results found for your search."

    Examples:
      | role        | company      | Module | SubModule        |Button  |
      | Super Admin | Titan Deploy | Items  | Items Management |Service |

#  @Service_View @End_to_End
  Scenario Outline: Validate View Of the Service
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    Then User Validate the Service View Page

    Examples:
      | role        | company      | Module | SubModule        | Button  | Actions |
      | Super Admin | Titan Deploy | Items  | Items Management | Service | View    |

#  @Service_Update @End_to_End
  Scenario Outline: Validate Update Of the Service
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    When User fill the update details in Service
    When User Clicks on "<button>" in Wakanda Books
    Then User validated updated the message in Service

    Examples:
      | role        | company      | Module | SubModule        | Button  | Actions | button |
      | Super Admin | Titan Deploy | Items  | Items Management | Service | Edit    | Save   |

#  @Service_Delete @End_to_End
  Scenario Outline: Validate Delete Of the Service
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    When User Clicks on delete in Wakanda Books
    Then User validated deleted the message
    Examples:
      | role        | company      | Module | SubModule        | Button  | Actions |
      | Super Admin | Titan Deploy | Items  | Items Management | Service | Delete  |

#  @Service_Retore @End_to_End
  Scenario Outline: Validate Deleted Of the service Restore
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User Clicks on deleted List
#    Then User validated deleted Item
    When User Restore the deleted item
    Then User Validate the Restore the item
    Examples:
      | role        | company      | Module | SubModule        | Button  |
      | Super Admin | Titan Deploy | Items  | Items Management | Service |

#  @Sevice_Empty_Filed_Validaton @End_to_End
  Scenario Outline: Validate product creation with empty mandatory fields
    When User login on "<role>" in Wakanda Books
    And User select "<company>" on login page
    And User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    And User clicks on "Add Service" in Items list
    And User enter "Service" details with name "<ServiceName>" unit "<Unit>" and category "<Category>"
    When User Clicks on "<button>" in Wakanda Books
    Then User should see validation message "<ErrorMessage>" and product should not be created

    Examples:
      | role        | company      | Module | SubModule        | ServiceName    | Unit | Category | button | ErrorMessage         | Button  |
      | Super Admin | Titan Deploy | Items  | Items Management |                | H    | Hardware | Save   | Name is required     | Service |
      | Super Admin | Titan Deploy | Items  | Items Management | Mobile Serivce |      | Hardware | Save   | Unit is required     | Service |
      | Super Admin | Titan Deploy | Items  | Items Management | Mobile Serivce | H    |          | Save   | Category is required | Service |

#  @Category_Creation_Product @TC001 @End_to_End
  Scenario Outline: Validate Creation Of the Category in Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    Then User Validate the list before "<Catagory>" Creation
    When User clicks on "Add Category" in Items list
    And User Click on "Product" option
    And User Enter the "<Catagory>"name and Description
    And User Clicks on "Save Category" in Wakanda Books
    Then User Validate the in List

    Examples:
      | role        | company      | Module | SubModule        | Button   | Catagory |
      | Super Admin | Titan Deploy | Items  | Items Management | Category | Garment  |

#  @Category_Update_Product @TC001 @End_to_End
  Scenario Outline: Validate Update Of the Product Category
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    And User Enter the "<Catagory>"name and Description
    And User Clicks on "Update Category" in Wakanda Books
    Then User validated updated the message

    Examples:
      | role        | company      | Module | SubModule        | Button   | Actions | Catagory |
      | Super Admin | Titan Deploy | Items  | Items Management | Category | Edit    | Garments |

#  @Category_Delete_Product @TC001 @End_to_End
  Scenario Outline: Validate Delete Of the Product Category
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    When User Clicks on delete in Wakanda Books
    Then User validated deleted the message
    Examples:
      | role        | company   | Module | SubModule  | Button   | Actions |
      | Super Admin | wsolution | Items  | Items List | Category | Delete  |

#  @Category_Delete_Product_Restore @TC001 @End_to_End
  Scenario Outline: Validate Deleted Of the Product Category Restore
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User Clicks on deleted List
#    Then User validated deleted Item in category
    When User Restore the deleted item
    Then User Validate the Restore the item in category
    Examples:
      | role        | company      | Module | SubModule        | Button   |
      | Super Admin | Titan Deploy | Items  | Items Management | Category |

#  @Category_Delete_Product_Empty_Filed_Validation @TC001 @End_to_End
  Scenario Outline: Validate product category creation with empty mandatory fields
    When User login on "<role>" in Wakanda Books
    And User select "<company>" on login page
    And User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    And User clicks on "Add Category" in Items list
    And User Click on "Product" option
    And User Enter the "<Category>"name and Description
    And User Clicks on "Save Category" in Wakanda Books
    Then User should see validation message "<ErrorMessage>" and product should not be created

    Examples:
      | role        | company      | Module | SubModule        | Category | ErrorMessage         | Button   |
      | Super Admin | Titan Deploy | Items  | Items Management |          | Category is required | Category |

#  @Service_Category_Creation @TC001 @End_to_End
  Scenario Outline: Validate Creation Of the Category in Service
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "Add Category" in Items list
    And User Click on "Service" option
    And User Enter the "<Catagory>"name and Description
    And User Clicks on "Save Category" in Wakanda Books
    Then User Validate the in List

    Examples:
      | role        | company      | Module | SubModule        | Button   | Catagory      |
      | Super Admin | Titan Deploy | Items  | Items Management | Category | Water Service |

#  @Service_Category_Update @TC001 @End_to_End
  Scenario Outline: Validate Update Of the Service Category
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    And User Enter the "<Catagory>"name and Description
    And User Clicks on "Update Category" in Wakanda Books
    Then User validated updated the message

    Examples:
      | role        | company      | Module | SubModule        | Button   | Actions | Catagory       |
      | Super Admin | Titan Deploy | Items  | Items Management | Category | Edit    | Water Services |

#  @Service_Category_Delete @TC001 @End_to_End
  Scenario Outline: Validate Delete Of the Service Category
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    When User Clicks on delete in Wakanda Books
    Then User validated deleted the message
    Examples:
      | role        | company      | Module | SubModule        | Button   | Actions |
      | Super Admin | Titan Deploy | Items  | Items Management | Category | Delete  |

#  @Service_Category_Restore @TC001 @End_to_End
  Scenario Outline: Validate Deleted Of the Service Category Restore
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User Clicks on deleted List
#    Then User validated deleted Item in category
    When User Restore the deleted item
    Then User Validate the Restore the item in category
    Examples:
      | role        | company      | Module | SubModule        | Button   |
      | Super Admin | Titan Deploy | Items  | Items Management | Category |

#  @Service_Category_Empty_Filed_Validation @TC001 @End_to_End
  Scenario Outline: Validate Service category creation with empty mandatory fields
    When User login on "<role>" in Wakanda Books
    And User select "<company>" on login page
    And User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    And User clicks on "Add Category" in Items list
    And User Click on "Service" option
    And User Enter the "<Category>"name and Description
    And User Clicks on "Save Category" in Wakanda Books
    Then User should see validation message "<ErrorMessage>" and product should not be created

    Examples:
      | role        | company      | Module | SubModule  | Category | ErrorMessage         | Button   |
      | Super Admin | Titan Deploy | Items  | Items List |          | Category is required | Category |

#  @Unit_Creation @TC002 @End_to_End
  Scenario Outline: Validate Creation Of the Unit
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "Add Unit" in Items list
    And User Enter the "<Name>"name and "<Symbol>"
    And User Clicks on "Add Unit" in Wakanda Books
    Then User Validate the in List on Unit

    Examples:
      | role        | company      | Module | SubModule  | Button | Name      | Symbol |
      | Super Admin | Titan Deploy | Items  | Items List | Unit   | Unit Oneo | UNOo   |

 # @Unit_Update @TC002
  Scenario Outline: Validate Update Of the Unit
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on Edit Button
    And User Enter the "<Name>"name and "<Symbol>"
    And User Clicks on "Update Unit" in Wakanda Books
    Then User Validate the in List on Unit

    Examples:
      | role        | company   | Module | SubModule  | Button | Name     | Symbol |
      | Super Admin | wsolution | Items  | Items List | Unit   | Unit Two | UNT    |

#  @Unit_Delete @TC002 @End_to_End
  Scenario Outline: Validate Delete Of the Unit
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on Delete Button
    When User Clicks on delete in Wakanda Books
    Then User validated updated the message

    Examples:
      | role        | company   | Module | SubModule  | Button | Name  | Symbol |
      | Super Admin | wsolution | Items  | Items List | Unit   | Ziyas | ZXY    |

#  @Unit_Restore @TC002 @End_to_End
  Scenario Outline: Validate Deleted Of the Service Category Restore
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User Clicks on deleted List
    Then User Validate the in List on Unit
    When User Restore the deleted item
    Then User Validate the in List on Unit
    Examples:
      | role        | company   | Module | SubModule  | Button |
      | Super Admin | wsolution | Items  | Items List | Unit   |