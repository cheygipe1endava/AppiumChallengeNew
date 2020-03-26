Feature: Login

  Scenario: The user successfully login in Kijiji's app with previous account created
    Given the user is in Kijiji's home page
    And the user clicks on menu icon
    When the user clicks on sign in button and selects sign in option button
    And types in its credentials for email and password and enters them by clicking sign in button
      | email    | testdummy4785692@gmail.com |
      | password | 3zM87=9",A                 |
    Then the user should be signed in
    And the user logs out from session

  Scenario: The user unsuccessfully login in Kijiji's app with both wrong credentials
    Given the user is in Kijiji's home page
    And the user clicks on menu icon
    When the user clicks on sign in button and selects sign in option button
    And types in its credentials for email and password and enters them by clicking sign in button
      | email    | testdummy@gmail.com |
      | password | 45[BC\5Lm+          |
    Then the user cannot login because app shows error with credentials

  Scenario: The user unsuccessfully login in Kijiji's app with wrong email
    Given the user is in Kijiji's home page
    And the user clicks on menu icon
    When the user clicks on sign in button and selects sign in option button
    And types in its credentials for email and password and enters them by clicking sign in button
      | email    | testdummy@gmail.com |
      | password | 3zM87=9",A          |
    Then the user cannot login because app shows error with credentials

  Scenario: The user unsuccessfully login in Kijiji's app with wrong password
    Given the user is in Kijiji's home page
    And the user clicks on menu icon
    When the user clicks on sign in button and selects sign in option button
    And types in its credentials for email and password and enters them by clicking sign in button
      | email    | testdummy4785692@gmail.com |
      | password | 45[BC\5Lm+                 |
    Then the user cannot login because app shows error with credentials