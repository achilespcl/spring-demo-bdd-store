Feature: Remove a product of store

  As a user, I want to remove a product of my store

  Scenario: Remove a product by id with success
    Given I have a product in my store with an id 11
    When I make a delete request to my api sending the product id
    Then My product was removed from my store