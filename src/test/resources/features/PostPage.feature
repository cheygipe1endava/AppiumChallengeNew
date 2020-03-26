Feature: Post page

  Background: The user signs in Kijiji's app
    Given the user logs in Kijiji's web page
      | email    | testdummy4785692@gmail.com |
      | password | 3zM87=9",A                 |
    And the user searches for cars and vehicle's first match in Canada

  Scenario: The user saves car post as favourite
    Given the user is in first pick of Kijiji's cars post page
    When the user clicks on heart icon at top right corner
    And the user goes to favourites section in home menu
    Then the user should have successfully saved post as its favourite
    And the user deletes post from favourites
    And the user closes the session

  Scenario: The user needs to see seller's profile
    Given the user is in first pick of Kijiji's cars post page
    When the user clicks on seller's name
    Then the user should have been redirected to the seller's profile page
    And the user goes back to home page
    And the user closes the session

