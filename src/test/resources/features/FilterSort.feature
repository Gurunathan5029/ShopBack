@shopback @filtersort
Feature: Filter and sort product listing

  @filter @ui
  Scenario Outline: Verify user is able to filter the products
    Given shopback page is launched
    When user click on user Icon
    And login with VALID credentials
    And user should be successfully logged in
    And select product Tablet under Tablets sub category under the Mobiles & Tablets main category
    And verify product page is displayed
    And apply <FilterType> filter with value <FilterValue>
    Then product listing should be listed based on filter
    And verify next page is also listed based on FILTER applied

    Examples:
      | FilterType | FilterValue |
      | BRANDS     | Samsung     |

  @sort @ui
  Scenario Outline: Verify user is able to sort the products
    Given shopback page is launched
    When user click on user Icon
    And login with VALID credentials
    And user should be successfully logged in
    And select product Tablet under Tablets sub category under the Mobiles & Tablets main category
    And verify product page is displayed
    And sort the listing with <SortType>
    And product listing should be listed based on sortType
    And verify next page is also listed based on SORT applied

    Examples:
      | SortType          |
      | PRICE_HIGH_TO_LOW |