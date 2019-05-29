Feature: Review
  As an end user
  I want to select products according to specific price range
  So that i can buy a product according to my preference

  Background:
    Given I am on homepage
    When I search for a product "nike"

  @reg
  Scenario Outline: Filter by Price range

    And I apply filter "<filter rating>" on search result
    Then I should see all products "range" are filtered "<expected value>"

    Examples:
      |filter rating| expected value|
      |£10 - £15    | 10 - 15          |
      |£15 - £20    | 15 - 20          |





  @regr
  Scenario Outline: Filter By Rating

    And I apply filter "<filter value>" on search result
    Then I should see all products "review" are filtered "<expected Value>"

    Examples:
      |filter value| expected Value|
      |4or more   | 4.0         |
      |3or more   | 3.0         |




