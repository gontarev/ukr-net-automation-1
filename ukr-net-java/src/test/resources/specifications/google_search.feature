Feature: Search with Google
  With Google I can search information in the Internet

  Scenario: I search articles about Selenium in the Internet
    Given Google search is opened in my browser
    When I enter search term "Selenium"
    Then Search results contains links for "Selenium" related resources
    When I click on first search results
    Then Opened page should contain info about "Selenium"
    And There is no any results for "ukr.net"

    Scenario: I count search results
      Given Google search is opened in my browser
      When I enter search term "Selenium"
      Then Search results page contains 11 results