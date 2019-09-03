Feature: Auto answer
  A live project test

  Background:
    Given User on the main page

  Scenario:Check auto answer is working
    When User click on customer service
    And User type into input "Üdvözlő lehelletem!"
    And User send the message with click
    Then Answerer name has to be "Chuck Norris"
