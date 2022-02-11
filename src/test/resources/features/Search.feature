@shopback
Feature: Search Product

  @ui @p1 @search
  Scenario Outline: Verify user is successfully able to search product and select
    Given shopback page is launched
    When user click on user Icon
    And login with VALID credentials
    And user should be successfully logged in
    And select product <Product> under <Sub_Category> sub category under the <Prime_Category> main category
    Then verify product page is displayed

    Examples:
      | Prime_Category    | Sub_Category | Product |
      | Mobiles & Tablets | Tablets      | Tablet  |