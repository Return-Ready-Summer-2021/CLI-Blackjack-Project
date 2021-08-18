# Java CLI Blackjack Lab

## Description
You will create a Blackjack game in the command line. The following should be possible:

* The system should store the deck as a shuffled list of Card, each card represented as a Suit and Rank
* Bonus: The system should represent Suit and Rank as Enums
* The system should deal two cards from the deck to both the dealer and player
* The user can view one of the cards the dealer was dealt
* The user can view the two cards they were dealt
* The user can choose to HIT, STAND, DOUBLE (conditionally), or SPLIT
  * The user receives another card if they choose to HIT
  * The user receives another card if they choose DOUBLE and it becomes the dealer's turn
  * It becomes the dealer's turn if the user chooses to STAND
* The user should have the option to SPLIT if they are dealt two cards of the same rank 
  * The system splits the user's hand into two hands if they choose SPLIT
* The user will BUST if the card they recieved puts their hand over 21 and the dealer wins
* Once it is the dealer's turn, the system deals the dealer cards until they either BUST, the dealer's cards total 17+, or they beat the players hand
* The user can choose to play again or quit

## Examples

```text
cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: A of D
Your cd.rr.blackjack.Hand: 2 of C, 3 of H

Your Move: HIT

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: A of D
Your cd.rr.blackjack.Hand: 2 of C, 3 of H, 10 of H

Your Move: HIT

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: A of D
Your cd.rr.blackjack.Hand: 2 of C, 3 of H, 10 of H, K of S

BUST! cd.rr.blackjack.Dealer Wins!
Play again (y/n): y

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: K of C
Your cd.rr.blackjack.Hand: 10 of C, 9 of S

Your Move: STAND

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: A of D, 6 of D, 7 of H
Your cd.rr.blackjack.Hand: 10 of C, 9 of S

cd.rr.blackjack.Dealer Bust! You win!
Play again (y/n): n

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: A of D
Your cd.rr.blackjack.Hand: 2 of C, 9 of H

Your Move: DOUBLE

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: K of D, 7 of D
Your cd.rr.blackjack.Hand: 2 of C, 9 of H, 7 of H

cd.rr.blackjack.Dealer must Stand! You win!
Play again (y/n): y

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: K of D
Your cd.rr.blackjack.Hand: 9 of C, 9 of H

Your Move: SPLIT

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: K of D
Your First cd.rr.blackjack.Hand: 9 of C
Your Second cd.rr.blackjack.Hand: 9 of H

Your Move: HIT

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: K of D
Your First cd.rr.blackjack.Hand: 9 of C, J of S
Your Second cd.rr.blackjack.Hand: 9 of H

Your Move: STAND

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: K of D
Your First cd.rr.blackjack.Hand: 9 of C, J of S
Your Second cd.rr.blackjack.Hand: 9 of H

Your Move: HIT

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: K of D
Your First cd.rr.blackjack.Hand: 9 of C, J of S
Your Second cd.rr.blackjack.Hand: 9 of H, 6 of S

Your Move: HIT

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: K of D
Your First cd.rr.blackjack.Hand: 9 of C, J of S
Your Second cd.rr.blackjack.Hand: 9 of H, 6 of S, 9 of S

Your Second cd.rr.blackjack.Hand Bust!

cd.rr.blackjack.Dealer cd.rr.blackjack.Hand: K of D, 7 of D
Your First cd.rr.blackjack.Hand: 9 of C, J of S
Your Second cd.rr.blackjack.Hand: 9 of H, 6 of S, 9 of S

cd.rr.blackjack.Dealer must Stand! You win!
Play again (y/n): n
```

## Submission

Commit and push all of your changes to your GitHub repo.

*Happy Hacking*
