Feature: AddOneProductToCart
  Add one product to shopping cart

  Scenario: One of the first product to cart
    Given User on the main page
    When User click on add first product button
    When User click on shopping cart button
    Then Product quantity should be one


Feature: AddMultipleProductToCart
  Add multiple product to shopping cart

  Scenario: Two of the first product to cart
    Given User on the main page
    When User click twice on add first product button
    When User click on shopping cart button
    Then Product quantity should be two

