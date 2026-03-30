Feature: Add Products to Cart
  As a customer
  I want to add products to my cart
  So that I can purchase them later

  Background:
    Given the user is on the Demoblaze home page

  @e2e
  Scenario: Add first two products to cart
    When the user adds the first product to the cart
    And the user adds the second product to the cart
    And the user navigates to the cart
    Then the cart should contain 2 product(s)
    And the cart should display the added products
    And the total price should be displayed

  @e2e
  Scenario: Add specific product to cart
    When the user adds "Samsung galaxy s6" to the cart
    And the user navigates to the cart
    Then the cart should contain 1 product(s)
    And the cart should display "Samsung galaxy s6"
