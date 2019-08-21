#language: en
Feature:

  As a user, I want to add a new product to my store

  Scenario: Add a new product with success
    Given I have a new Product in my store
    When I fill the name "livro", description "Harry Potter" and price of 12.50
    Then I have a new product in my store