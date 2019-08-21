Feature: Get a product on store

  As a user, I want to find a product on my store

  Scenario: find a product by id with success
    Given I have a product in my store with a valid id
    When I make a request to my api sending the product id
    Then I get the respective product