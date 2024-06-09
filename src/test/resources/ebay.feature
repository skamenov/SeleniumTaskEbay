Feature: Monopoly orders Ebay

  Background:
    Given Navigate to "https://ebay.com/"
    Then Verify that the page is correct and opened
    When Select from drop down list “Toys & Games”, then search for Monopoly

  @verify_search_options
  Scenario: Verifying Monopoly search and options
    Then Verify that the first items have the title: Monopoly
    And Verify that there is a shipping to Bulgaria
    And Verify that there is a price of the item

  @verify_selected_option
  Scenario: Verifying the selected option
    When Click on the first item to navigate to details page
    Then Verify that the title of the item contains Monopoly
    And Verify that the price is the same as on the first page
    When Switch view from Description to Shipping and payments
    Then Verify that Bulgaria exists in the country drop down list

  @verify_cart_items
  Scenario: Verifying the items in the cart
    When Click on the first item to navigate to details page
    And Select quantity "2" and click Add to cart
    Then Verify that you are on "https://cart.payments.ebay.com/"
    And Verify that in the Qty Drop Down List the quantity is "2"
    And Verify that the price is displayed for two items