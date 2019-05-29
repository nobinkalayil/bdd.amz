Feature: Remove
  As an end user
  I want to remove a product from basket
  So that basket will be empty

  @remove
  Scenario: Remove a product from basket

    Given I am on homepage
    When I search for a product "nike"
    And I select any product
    And I add the product to the basket
    And The product should be in the basket
    Then I removed product from the basket