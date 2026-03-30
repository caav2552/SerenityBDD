Feature: Complete Purchase Flow
  As a customer
  I want to complete a full purchase from start to finish
  So that I can buy products from the store

  Background:
    Given the user is on the Demoblaze home page

  @e2e @main
  Scenario: Complete end-to-end purchase with two products
    When the user adds the first product to the cart
    And the user adds the second product to the cart
    And the user navigates to the cart
    Then the cart should contain 2 product(s)
    And the cart should display the added products
    And the total price should be displayed
    When the user proceeds to place the order
    And the user fills the checkout form with:
      | Name        | John Doe           |
      | Country     | United States      |
      | City        | New York           |
      | Credit card | 4111111111111111   |
      | Month       | 12                 |
      | Year        | 2025               |
    And the user completes the purchase
    Then the purchase should be confirmed
    And the confirmation should display order details

  @e2e
  Scenario: Purchase specific product
    When the user adds "Samsung galaxy s6" to the cart
    And the user navigates to the cart
    Then the cart should contain 1 product(s)
    And the cart should display "Samsung galaxy s6"
    When the user proceeds to place the order
    And the user fills the checkout form with:
      | Name        | Jane Smith         |
      | Country     | Canada             |
      | City        | Toronto            |
      | Credit card | 5500000000000004   |
      | Month       | 06                 |
      | Year        | 2026               |
    And the user completes the purchase
    Then the purchase should be confirmed
