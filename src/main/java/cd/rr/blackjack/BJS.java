package cd.rr.blackjack;

import java.util.ArrayList;
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
    Dealer dealer = new Dealer();

    void rules() {
        System.out.println("        Welcome to BlackJack!      ");
        System.out.println("---------------------------------------");
        System.out.println("          Here are the rules          ");
        System.out.println("1. Each player starts with two cards, one of the dealer's cards is hidden until the end.");
        System.out.println("2. To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.");
        System.out.println("3. If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.");
        System.out.println("4. cd.rr.blackjack.Dealer will hit until his/her cards total 17 or higher.");
        System.out.println("5. Doubling is like a hit, only the bet is doubled and you only get one more card.");
        System.out.println("6. Split can be done when you have two of the same card - the pair is split into two hands.");
        System.out.println("7. You can only double/split on the first move, or first move of a hand created by a split.");
        System.out.println("8. The goal of blackjack is to beat the dealer's hand without going over 21.");
        System.out.println("9. Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.");

    }

    public void startDeal() {
        Scanner input = new Scanner(System.in);
        int userStartBet;


        System.out.print("How much would you like to bet?: ");

        if (!player.placeBet(input.nextInt())) {
            do {
                System.out.println("That bet is more than you have, try again");
                System.out.print("How much would you like to bet?: ");
            }while (!player.placeBet(input.nextInt()));
        }


            playerHand.hand.add(bjDeck.getDeck(0));
            bjDeck.deck.remove(0);
            addPlayerScore(0);
            playerHand.hand.add(bjDeck.getDeck(0));
            bjDeck.deck.remove(0);
            addPlayerScore(1);
            dealerHand.hand.add(bjDeck.getDeck(0));
            bjDeck.deck.remove(0);
            dealerHand.hand.add(bjDeck.getDeck(0));
            getViewableDealerHand();
            bjDeck.deck.remove(0);
            addDealerScore(0);


            System.out.println(player.getName() + "'s Hand: " + getPlayerHand());
            System.out.println("PLayer Score: " + getPlayerScore());
            System.out.println("Dealer's Hand: " + viewDealerHand());


    }

    public void deckShuffle() {
        Collections.shuffle(bjDeck.deck);

    }


    public void optionChecker() {

        Scanner scanner = new Scanner(System.in);
        String optionChecker;
        char o;
        int cardSlot;
        do {
            System.out.println("Which option would you like to choose: hit, split, double, or stand? ");
            optionChecker = scanner.next();
            o = optionChecker.charAt(0);

            if (o == 's') {
                break;
            }

            if (splitPlayerHand.hand.size() > 0) {
                Scanner input = new Scanner(System.in);
                int handChoice;
                System.out.print("Which hand would you like to use?(1/2): ");
                handChoice = input.nextInt();

                if (handChoice == 1) {
                    switch (o) {
                        case 'h':
                            System.out.println("Hit!");
                            playerHand.hand.add(bjDeck.getDeck(0));
                            bjDeck.deck.remove(0);
                            System.out.println(playerHand.getHand());
                            cardSlot = playerHand.hand.size() - 1;
                            addPlayerScore(cardSlot);
                            break;
                        case 'p':
                            System.out.println("Split!");
                            if (playerHand.hand.size() == 2 && splitPlayerHand.hand.size() == 0) {
                                boolean match;
                                match = playerHand.hand.get(0).getRank().equals(playerHand.hand.get(1).getRank());
                                if (match) {
                                    splitHand();
                                }
                                else {
                                    System.out.println("No match!");
                                }
                            }
                            else {
                                System.out.println("You already split!");
                            }

                            break;
                        case 'd':

                            System.out.println("Double");
                            System.out.println("Current Bet: " + player.getBet());
                            System.out.println("How much would you like to add to your bet?");
                            playerHand.hand.add(bjDeck.getDeck(0));
                            bjDeck.deck.remove(0);
                            player.addBet(scanner.nextInt());
                            System.out.println(player.getBet());
                            System.out.println(playerHand.getHand());
                            cardSlot = playerHand.hand.size();
                            addPlayerScore(cardSlot-1);
                            break;
                        default:
                            System.out.println("No option was chosen");
                            break;
                    }
                }
                else if (handChoice == 2) {
                    switch (o) {
                        case 'h':
                            System.out.println("Hit!");
                            splitPlayerHand.hand.add(bjDeck.getDeck(0));
                            bjDeck.deck.remove(0);
                            System.out.println(splitPlayerHand.getHand());
                            cardSlot = splitPlayerHand.hand.size();
                            addPlayerScore(cardSlot-1);
                            break;
                        case 'p':
                            System.out.println("You already split!");

                            break;
                        case 'd':

                            System.out.println("Double");
                            System.out.println("Current Bet: " + player.getBet());
                            System.out.println("How much would you like to add to your bet?");
                            splitPlayerHand.hand.add(bjDeck.getDeck(0));
                            bjDeck.deck.remove(0);
                            player.addBet(scanner.nextInt());
                            System.out.println(player.getBet());
                            System.out.println(splitPlayerHand.getHand());
                            cardSlot = splitPlayerHand.hand.size();
                            addPlayerScore(cardSlot-1);
                            break;
                        default:
                            System.out.println("No option was chosen");
                            break;
                    }
                }
            }
            else {
                switch (o) {
                    case 'h':
                        System.out.println("Hit!");
                        playerHand.hand.add(bjDeck.getDeck(0));
                        bjDeck.deck.remove(0);
                        System.out.println(playerHand.getHand());
                        cardSlot = playerHand.hand.size();
                        addPlayerScore(cardSlot-1);
                        break;
                    case 'p':
                        System.out.println("Split!");
                        if (playerHand.hand.size() == 2) {
                            boolean match;
                            match = playerHand.hand.get(0).getRank().equals(playerHand.hand.get(1).getRank());
                            if (match) {
                                splitHand();
                            }
                            else {
                                System.out.println("No match!");
                            }
                        }
                        else {
                            System.out.println("You already split!");
                        }

                        break;
                    case 'd':

                        System.out.println("Double");
                        System.out.println("Current Bet: " + player.getBet());
                        System.out.println("How much would you like to add to your bet?");
                        playerHand.hand.add(bjDeck.getDeck(0));
                        bjDeck.deck.remove(0);
                        player.addBet(scanner.nextInt());
                        System.out.println(player.getBet());
                        System.out.println(playerHand.getHand());
                        cardSlot = playerHand.hand.size();
                        addPlayerScore(cardSlot-1);
                        break;
                    default:
                        System.out.println("No option was chosen");
                        break;
                }
            }


            System.out.println(getPlayerScore());
            System.out.println(getSplitPlayerScore());
        }
        while (player.score < 21);
        System.out.println("Turn over.");
    }

    public void dealerHit() {
        if ((dealer.score < player.score || dealer.score < 17)) {
            do {
                viewableDealerHand.hand.add(bjDeck.deck.get(0));
                bjDeck.deck.remove(0);
                int cardSlot = viewableDealerHand.hand.size() - 1;
                addDealerScore(cardSlot);
            } while (dealer.score < player.score || dealer.score < 17);
        }
        if (splitPlayerHand.hand.size() > 0) {
            if ((dealer.score < player.splitScore || dealer.score < 17)) {
                do {
                    viewableDealerHand.hand.add(bjDeck.deck.get(0));
                    bjDeck.deck.remove(0);
                    int cardSlot = viewableDealerHand.hand.size() - 1;
                    addDealerScore(cardSlot);
                } while (dealer.score < player.splitScore || dealer.score < 17);
            }
        }

    }



    public ArrayList<Card> getPlayerHand() {
        return playerHand.hand;
    }

    public void getViewableDealerHand() {
        viewableDealerHand.hand.add(dealerHand.hand.get(1));
        dealerHand.hand.remove(1);
    }



    public ArrayList<Card> viewDealerHand() {
        return viewableDealerHand.hand;
    }
    private ArrayList<Card> getDealerHand() {
        viewableDealerHand.hand.add(dealerHand.hand.get(0));
        return viewableDealerHand.hand;
    }

    public int getPlayerScore() {
        return player.score;
    }
    public int getSplitPlayerScore() {
        return player.splitScore;
    }

    public int getDealerScore() {
        return dealer.score;
    }
    public void clearScore() {
        player.score = 0;
        dealer.score = 0;
        player.splitScore = 0;
    }
    public void clearHand() {
        discardDeck.deck.addAll(playerHand.hand);
        playerHand.hand.clear();
        discardDeck.deck.addAll(viewableDealerHand.hand);
        viewableDealerHand.hand.clear();
        dealerHand.hand.clear();
        discardDeck.deck.addAll(splitPlayerHand.hand);
        splitPlayerHand.hand.clear();

    }

    public void addPlayerScore(int i) {
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
    public void splitHand() {
        splitPlayerHand.hand.add(playerHand.hand.get(1));
        playerHand.hand.remove(1);
        CardENUM.Rank cardRank = splitPlayerHand.hand.get(0).getRank();
        if (cardRank == CardENUM.Rank.TWO) {
            player.splitScore += 2;
            player.score -= 2;
        }
        else if (cardRank == CardENUM.Rank.THREE) {
            player.splitScore += 3;
            player.score -= 3;
        }
        else if (cardRank == CardENUM.Rank.FOUR) {
            player.splitScore += 4;
            player.score -= 4;
        }
        else if (cardRank == CardENUM.Rank.FIVE) {
            player.splitScore += 5;
            player.score -= 5;
        }
        else if (cardRank == CardENUM.Rank.SIX) {
            player.splitScore += 6;
            player.score -= 6;
        }
        else if (cardRank == CardENUM.Rank.SEVEN) {
            player.splitScore += 7;
            player.score -= 7;
        }
        else if (cardRank == CardENUM.Rank.EIGHT) {
            player.splitScore += 8;
            player.score -= 8;
        }
        else if (cardRank == CardENUM.Rank.NINE) {
            player.splitScore += 9;
            player.score -= 9;
        }
        else if (cardRank == CardENUM.Rank.TEN) {
            player.splitScore += 10;
            player.score -= 10;
        }
        else if (cardRank == CardENUM.Rank.JACK) {
            player.splitScore += 10;
            player.score -= 10;
        }
        else if (cardRank == CardENUM.Rank.QUEEN) {
            player.splitScore += 10;
            player.score -= 10;
        }
        else if (cardRank == CardENUM.Rank.KING) {
            player.splitScore += 10;
            player.score -= 10;
        }
        else if (cardRank == CardENUM.Rank.ACE) {
            if (player.score > 10) {
                player.splitScore += 11;
                player.score -= 1;
            }
            else {
                player.splitScore += 11;
                player.score -= 11;
            }

        }

    }

    public void addSplitPlayerScore(int i) {
        CardENUM.Rank cardRank = playerHand.hand.get(i).getRank();
        if (cardRank == CardENUM.Rank.TWO) {
            player.splitScore += 2;
        }
        else if (cardRank == CardENUM.Rank.THREE) {
            player.splitScore += 3;
        }
        else if (cardRank == CardENUM.Rank.FOUR) {
            player.splitScore += 4;
        }
        else if (cardRank == CardENUM.Rank.FIVE) {
            player.splitScore += 5;
        }
        else if (cardRank == CardENUM.Rank.SIX) {
            player.splitScore += 6;
        }
        else if (cardRank == CardENUM.Rank.SEVEN) {
            player.splitScore += 7;
        }
        else if (cardRank == CardENUM.Rank.EIGHT) {
            player.splitScore += 8;
        }
        else if (cardRank == CardENUM.Rank.NINE) {
            player.splitScore += 9;
        }
        else if (cardRank == CardENUM.Rank.TEN) {
            player.splitScore += 10;
        }
        else if (cardRank == CardENUM.Rank.JACK) {
            player.splitScore += 10;
        }
        else if (cardRank == CardENUM.Rank.QUEEN) {
            player.splitScore += 10;
        }
        else if (cardRank == CardENUM.Rank.KING) {
            player.splitScore += 10;
        }
        else if (cardRank == CardENUM.Rank.ACE) {
            if (player.splitScore > 10) {
                player.splitScore += 1;
            }
            else {
                player.splitScore += 11;
            }

        }
    }

    public void addDealerScore(int index) {
        CardENUM.Rank cardRank = viewableDealerHand.hand.get(index).getRank();
        if (cardRank == CardENUM.Rank.TWO) {
            dealer.score += 2;
        }
        else if (cardRank == CardENUM.Rank.THREE) {
            dealer.score += 3;
        }
        else if (cardRank == CardENUM.Rank.FOUR) {
            dealer.score += 4;
        }
        else if (cardRank == CardENUM.Rank.FIVE) {
            dealer.score += 5;
        }
        else if (cardRank == CardENUM.Rank.SIX) {
            dealer.score += 6;
        }
        else if (cardRank == CardENUM.Rank.SEVEN) {
            dealer.score += 7;
        }
        else if (cardRank == CardENUM.Rank.EIGHT) {
            dealer.score += 8;
        }
        else if (cardRank == CardENUM.Rank.NINE) {
            dealer.score += 9;
        }
        else if (cardRank == CardENUM.Rank.TEN) {
            dealer.score += 10;
        }
        else if (cardRank == CardENUM.Rank.JACK) {
            dealer.score += 10;
        }
        else if (cardRank == CardENUM.Rank.QUEEN) {
            dealer.score += 10;
        }
        else if (cardRank == CardENUM.Rank.KING) {
            dealer.score += 10;
        }
        else if (cardRank == CardENUM.Rank.ACE) {
            if (dealer.score > 10) {
                dealer.score += 1;
            }
            else {
                dealer.score += 11;
            }
        }

    }
    void scoreChecker() {
        System.out.println("Dealer's Cards: " + getDealerHand());
        addDealerScore(viewableDealerHand.hand.size() - 1);
        System.out.println(player.name + "'s score: " + getPlayerScore());
        System.out.println(player.name + "'s 2nd Hand score: " + getSplitPlayerScore());
        System.out.println("Dealer's score: " + getDealerScore());
        if (player.score > dealer.score && player.score <= 21) {
            System.out.println(player.getName() + " wins!");
            player.totalChip += player.bet * 1.5;
            System.out.println(player.name + " won " + (player.bet * 1.5) + " chips!");

        }
        else if (player.score < dealer.score && dealer.score <= 21) {
            System.out.println("Dealer wins");

        }
        else if (player.score > 21 && dealer.score < 21) {
            System.out.println(player.getName() + " busts, Dealer wins!");

        }
        else if (dealer.score > 21 && player.score < 21) {
            System.out.println("Dealer busts, " + player.getName() + " wins!");
            player.totalChip += player.bet * 1.5;
            System.out.println(player.name + " won " + (player.bet * 1.5) + " chips!");

        }
        else if (player.score == dealer.score || player.splitScore == dealer.score) {
            System.out.println("Draw!");
            player.totalChip += player.bet;

        }
        player.bet = 0;
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        //catches if InterruptedException happens
        // if it does, it interrupts the current thread (thread.sleep
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
