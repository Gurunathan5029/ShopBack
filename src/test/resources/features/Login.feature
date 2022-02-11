@shopback
Feature: Login To Application

  @ui @p1 @login
  Scenario Outline: Verify user is successfully able to login to ShopBack
    Given shopback page is launched
    When user click on user Icon
    And login with <Credential_Format> credentials
    Then user should be successfully logged in

    Examples:
      | Credential_Format |
      | VALID             |
