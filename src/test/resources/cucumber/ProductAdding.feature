Feature: Product add to cart
  A live project test

  Background:
    Given User on the main page

  Scenario:Add one product to shopping cart
    When User click on add first product button
    And User click on shopping cart button
    Then First product quantity should be one

  Scenario:Add multiple product to shopping cart
    When User click twice on add first product button
    And User click on shopping cart button
    Then First product quantity should be two

  Scenario:Add different product to shopping cart
    When User click on add first product button
    When User click on add third product button
    And User click on shopping cart button
    Then First product quantity should be one
    And Second product quantity should be one

  Scenario:Add multiple and different product to shopping cart
    When User click twice on add first product button
    When User click twice on add third product button
    And User click on shopping cart button
    Then First product quantity should be two
    And Second product quantity should be two
