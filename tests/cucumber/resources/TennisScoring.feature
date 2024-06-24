Feature: Manage tennis game score
  Display the winner (if there is a winner) of a tennis game.

  Scenario: Manage a tennis game between two players
    Given a player named "Benoit PAIRE" and the adversary "Roger FEDERER"
    When the exchange are "AABABABABABAB".
    Then "Benoit PAIRE" is the winner of the game.
