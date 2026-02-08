Feature: 1-1-TC-01-Sample CREATION -
  This Feature file is used to create Sample.

  Background: User log in to Application
    Given User launches app "ACC" Environment

  @Product_Creation @End_to_End
  Scenario Outline: Validate Creation Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
#    When User clicks on "<Module>" and Select "<SubModule>"
#    When User clicks on "Add Product" in Items list
#    And User Field as "Product" and add Values "Locker", "Textiles","Electronics products" details
#    And User add Additional Information details
#    And User select "<Warehouse>" details and Information details
#    When User Clicks on "<button>" in Wakanda Books
#    Then User Validate the in Items List
#   # Then User Validate the Item in Full validation
#    When User clicks on "<Actions>" and fill the details
#    When User fill the update details
#    When User Clicks on "<button>" in Wakanda Books
#    Then User validated updated the message
#    When User clicks on "<Action>" and fill the details
#    When User Clicks on delete in Wakanda Books
#    Then User validated deleted the message
#    When User Clicks on deleted List
#    Then User validated deleted Item
#    When User Restore the deleted item
#    Then User Validate the Restore the item

    Examples:
      | role        | company       | Module | SubModule  | Warehouse     | button | Actions | Action |
      | Super Admin | Wakanda Books | Items  | Items List | GKS Warehouse | Save   | Edit    | Delete |

  @Product_Creation
  Scenario Outline: Validate Creation Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "Add Product" in Items list
    And User Field as "Product" and add Values "Raise", "KG","Grocery" details
    And User add "Sriniva" in Additional Information details
    And User select "<Warehouse>" details and Information details
    When User Clicks on "<button>" in Wakanda Books
    Then User Validate the in Items List
    Examples:
      | role        | company       | Module | SubModule  | Warehouse      | button |
      | Super Admin | Wakanda Books | Items  | Items List | Tony Warehouse | Save   |

  @Service_Creation  @Regression @TC01
  Scenario Outline: Validate View Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
#    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    Then User Validate the View in "Product"


    Examples:
      | role        | company   | Module | SubModule  | Button  | Actions |
      | Super Admin | wsolution | Items  | Items List | Service | View    |


  #@Product_Update @TC002
  Scenario Outline: Validate Update Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "<Actions>" and fill the details
    When User fill the update details
    When User Clicks on "<button>" in Wakanda Books
    Then User validated updated the message
    Examples:
      | role        | company   | Module | SubModule  | Actions | button |
      | Super Admin | wsolution | Items  | Items List | Edit    | Save   |


  @Product_Delete
  Scenario Outline: Validate Delete Of the Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User clicks on "<Actions>" and fill the details
    When User Clicks on delete in Wakanda Books
    Then User validated deleted the message
    Examples:
      | role        | company   | Module | SubModule  | Actions |
      | Super Admin | wsolution | Items  | Items List | Delete  |

  @Product_Restore
  Scenario Outline: Validate Deleted Of the Product Restore
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Clicks on deleted List
    Then User validated deleted Item
    When User Restore the deleted item
    Then User Validate the Restore the item
    Examples:
      | role        | company   | Module | SubModule  | Actions |
      | Super Admin | wsolution | Items  | Items List | Delete  |

  @Product_filed_Validation
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


  @Service_Creation
  Scenario Outline: Validate Creation Of the Service
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "Add Service" in Items list
    And User Field as "Service" and add Values "Mobile Repairing", "KG","Electronics Service" details
    And User add price details and in Additional Information
    When User Clicks on "<Save>" in Wakanda Books
    Then User Validate the in Items List

    Examples:
      | role        | company   | Module | SubModule  | Button  | Save |
      | Super Admin | wsolution | Items  | Items List | Service | Save |


  @Service_View
  Scenario Outline: Validate View Of the Service
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    Then User Validate the View in "Service"

    Examples:
      | role        | company   | Module | SubModule  | Button  | Actions |
      | Super Admin | wsolution | Items  | Items List | Service | View    |

  @Service_Update
  Scenario Outline: Validate Update Of the Service
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    When User fill the update details
    When User Clicks on "<button>" in Wakanda Books
    Then User validated updated the message

    Examples:
      | role        | company   | Module | SubModule  | Button  | Actions | button |
      | Super Admin | wsolution | Items  | Items List | Service | Edit    | Save   |

  @Service_Delete
  Scenario Outline: Validate Delete Of the Service
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "<Actions>" and fill the details
    When User Clicks on delete in Wakanda Books
    Then User validated deleted the message
    Examples:
      | role        | company   | Module | SubModule  | Button  | Actions |
      | Super Admin | wsolution | Items  | Items List | Service | Delete  |

  @Service_Retore
  Scenario Outline: Validate Deleted Of the service Restore
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User Clicks on deleted List
    Then User validated deleted Item
    When User Restore the deleted item
    Then User Validate the Restore the item
    Examples:
      | role        | company   | Module | SubModule  | Button  |
      | Super Admin | wsolution | Items  | Items List | Service |

  @Sevice_Empty_Filed_Validaton
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
      | role        | company   | Module | SubModule  | ServiceName    | Unit | Category | button | ErrorMessage         | Button  |
      | Super Admin | wsolution | Items  | Items List |                | H    | Hardware | Save   | Name is required     | Service |
      | Super Admin | wsolution | Items  | Items List | Mobile Serivce |      | Hardware | Save   | Unit is required     | Service |
      | Super Admin | wsolution | Items  | Items List | Mobile Serivce | H    |          | Save   | Category is required | Service |

  @Category_Creation_Product @TC001
  Scenario Outline: Validate Creation Of the Category in Product
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User clicks on "Add Category" in Items list
    And User Click on "Product" option
    And User Enter the "<Catagory>"name and Description
    And User Clicks on "Save Category" in Wakanda Books
    Then User Validate the in List

    Examples:
      | role        | company   | Module | SubModule  | Button   | Catagory |
      | Super Admin | wsolution | Items  | Items List | Category | Garment  |

  @Category_Update_Product @TC001
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
      | role        | company   | Module | SubModule  | Button   | Actions | Catagory |
      | Super Admin | wsolution | Items  | Items List | Category | Edit    | Garments |

  @Category_Delete_Product @TC001
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

  @Category_Delete_Product_Restore @TC001
  Scenario Outline: Validate Deleted Of the Product Category Restore
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User Clicks on deleted List
    Then User validated deleted Item in category
    When User Restore the deleted item
    Then User Validate the Restore the item in category
    Examples:
      | role        | company   | Module | SubModule  | Button   |
      | Super Admin | wsolution | Items  | Items List | Category |

  @Category_Delete_Product_Empty_Filed_Validation @TC001
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
      | role        | company   | Module | SubModule  | Category | ErrorMessage         | Button   |
      | Super Admin | wsolution | Items  | Items List |          | Category is required | Category |

  @Service_Category_Creation @TC001
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
      | role        | company   | Module | SubModule  | Button   | Catagory      |
      | Super Admin | wsolution | Items  | Items List | Category | Water Service |

  @Service_Category_Update @TC001
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
      | role        | company   | Module | SubModule  | Button   | Actions | Catagory       |
      | Super Admin | wsolution | Items  | Items List | Category | Edit    | Water Services |

  @Service_Category_Delete @TC001
  Scenario Outline: Validate Delete Of the Service Category
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

  @Service_Category_Restore @TC001
  Scenario Outline: Validate Deleted Of the Service Category Restore
    When User login on "<role>" in Wakanda Books
    When User select "<company>" on login page
    When User clicks on "<Module>" and Select "<SubModule>"
    When User Click on "<Button>" module
    When User Clicks on deleted List
    Then User validated deleted Item in category
    When User Restore the deleted item
    Then User Validate the Restore the item in category
    Examples:
      | role        | company   | Module | SubModule  | Button   |
      | Super Admin | wsolution | Items  | Items List | Category |

  @Service_Category_Empty_Filed_Validation @TC001
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
      | role        | company   | Module | SubModule  | Category | ErrorMessage         | Button   |
      | Super Admin | wsolution | Items  | Items List |          | Category is required | Category |

  @Unit_Creation @TC002
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
      | role        | company   | Module | SubModule  | Button | Name      | Symbol |
      | Super Admin | wsolution | Items  | Items List | Unit   | Unit Oneo | UNOo   |

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

  @Unit_Delete @TC002
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

  @Unit_Restore @TC002
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