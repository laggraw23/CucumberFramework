Feature: Searching New Car

  Scenario Outline: Finding New Car
    Given user navigate to carwale website
    When User mouseover to newcars
    Then user click on Findnewcars
    And user clicks on "<carBrand>" Car
    And user validates carTitle as "<carTitle>"

    Examples: 
      | carBrand | carTitle    |
      | Toyota   | Toyota Cars |
      | BMW      | BMW Cars    |
      | KIA      | Kia Carss   |
