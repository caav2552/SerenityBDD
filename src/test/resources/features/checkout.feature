Feature: Checkout Process
  As a customer
  I want to complete the checkout process
  So that I can finalize my purchase

  Background:
    Given the user is on the Demoblaze home page

  @e2e
  Scenario: Complete checkout with valid information
    When the user adds the first product to the cart
    And the user navigates to the cart
    And the user proceeds to place the order
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
