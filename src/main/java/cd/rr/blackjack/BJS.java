package cd.rr.blackjack;

import java.util.Collections;
import java.util.Scanner;


public class BJS {

    Hand playerHand = new Hand();
    Hand splitPlayerHand = new Hand();
    Deck bjDeck = new Deck();
    Deck discardDeck = new Deck();
    Hand dealerHand = new Hand();
    Hand viewableDealerHand = new Hand();
    Player player = new Player();

    public void startDeal() {
        playerHand.hand.add(bjDeck.getDeck(0));
        bjDeck.deck.remove(0);
        addScore(0);
        playerHand.hand.add(bjDeck.getDeck(0));
        bjDeck.deck.remove(0);
        addScore(1);
        dealerHand.hand.add(bjDeck.getDeck(0));
        bjDeck.deck.remove(0);
        dealerHand.hand.add(bjDeck.getDeck(0));
        bjDeck.deck.remove(0);



        System.out.println(playerHand.hand);
        viewDealerHand();
    }


        public void addBet(int bet) {
        player.bet+= bet;
    }

    public void optionChecker() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Which option would you like to choose: hit, split, double, or stand? ");
        String optionChecker = scanner.next();
        char o = optionChecker.charAt(0);
        do {

            switch (o) {
                case 'h':
                    System.out.println("Hit!");
                    playerHand.hand.add(bjDeck.getDeck(0));
                    bjDeck.deck.remove(0);
                    System.out.println(playerHand.getHand());
                    break;
                case 'p':
                    System.out.println("Split!");

                    break;
                case 'd':

                    System.out.println("Double");
                    System.out.println("Current Bet: " + player.getBet());
                    System.out.println("How much would you like to add to your bet?");
                    playerHand.hand.add(bjDeck.getDeck(0));
                    bjDeck.deck.remove(0);
                    addBet(scanner.nextInt());
                    System.out.println(player.getBet());
                    System.out.println(playerHand.getHand());


                    break;
                case 's':
                    System.out.println("Stand!");
                    System.out.println(playerHand.getHand());
                    break;
                default:
                    System.out.println("No option was chosen");
                    break;
            }
            System.out.println("Which option would you like to choose: hit, split, double, or stand? ");
            optionChecker = scanner.next();
            o = optionChecker.charAt(0);
        }
        while (o != 's');
        System.out.println("Turn over.");
    }


    public void deckShuffle() {
        Collections.shuffle(bjDeck.deck);

    }
    public void viewPlayerHand() {
        System.out.println("Player's Hand: " + playerHand.hand);
    }



    public void viewDealerHand() {
        viewableDealerHand.hand.add(0, dealerHand.hand.get(1));
        System.out.println("Dealer's Hand: " + viewableDealerHand.hand);
    }
    private Hand getDealerHand() {
        viewableDealerHand.hand.add(0, dealerHand.hand.get(0));
        return viewableDealerHand;
    }

    public int getScore() {
        return player.score;
    }
    public void clearScore() {
        player.score = 0;
    }

    public void addScore(int i) {
        CardENUM.Rank cardRank = playerHand.hand.get(i).getRank();
        if (cardRank == CardENUM.Rank.TWO) {
            player.score += 2;
        }
        else if (cardRank == CardENUM.Rank.THREE) {
            player.score += 3;
        }
        else if (cardRank == CardENUM.Rank.FOUR) {
            player.score += 4;
        }
        else if (cardRank == CardENUM.Rank.FIVE) {
            player.score += 5;
        }
        else if (cardRank == CardENUM.Rank.SIX) {
            player.score += 6;
        }
        else if (cardRank == CardENUM.Rank.SEVEN) {
            player.score += 7;
        }
        else if (cardRank == CardENUM.Rank.EIGHT) {
            player.score += 8;
        }
        else if (cardRank == CardENUM.Rank.NINE) {
            player.score += 9;
        }
        else if (cardRank == CardENUM.Rank.TEN) {
            player.score += 10;
        }
        else if (cardRank == CardENUM.Rank.JACK) {
            player.score += 10;
        }
        else if (cardRank == CardENUM.Rank.QUEEN) {
            player.score += 10;
        }
        else if (cardRank == CardENUM.Rank.KING) {
            player.score += 10;
        }
        else if (cardRank == CardENUM.Rank.ACE) {
            if (player.score > 10) {
                player.score += 1;
            }
            else {
                player.score += 11;
            }
        }

    }





    public static void main(String[] args) {


        //Start here!
        // use to shuffle array of deck
        // Collections.shuffle();

        // startDeal()
        // PlayerHand[0] = Deck[0]
        // Deck.remove[0]
        // PlayerHand[1]

        // h = hit;
        // if (player has 2 cards of same value
        // sp = split;
        // d = double;
        // turn ends after picked
        // st = stand;
        // turn ends after picked

        //mid game dealer
        // do {
        // dealerHand[] += Deck[0]
        // }
        // while (dealerHand <= 21 || dealerHand > 17 || dealerHand > playerHand
    }
}
