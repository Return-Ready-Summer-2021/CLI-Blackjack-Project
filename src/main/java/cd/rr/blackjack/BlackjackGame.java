package cd.rr.blackjack;

import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("        Welcome to BlackJack!      ");
        System.out.println("---------------------------------------");
        System.out.println("          Here are the rules          ");
        System.out.println("1. Each player starts with two cards, one of the dealer's cards is hidden until the end.");
        System.out.println("2. To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.");
        System.out.println("3. If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.");
        System.out.println("4. Dealer will hit until his/her cards total 17 or higher.");
        System.out.println("5. Doubling is like a hit, only the bet is doubled and you only get one more card.");
        System.out.println("6. Split can be done when you have two of the same card - the pair is split into two hands.");
        System.out.println("7. You can only double/split on the first move, or first move of a hand created by a split.");
        System.out.println("8. The goal of blackjack is to beat the dealer's hand without going over 21.");
        System.out.println("9. Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.");

        System.out.println("Would you like to start a new game ; yes or no?");
        String playerAnswer = input.nextLine();

        if(playerAnswer.equalsIgnoreCase("yes")) {

            Deck deck = new Deck();
            CardENUM card = new CardENUM();
            deck.shuffle();

            int dealerCard1 = random.nextInt(10) + 1;
            int dealerCard2 = random.nextInt(10) + 1;

            int playerCard1 = random.nextInt(10) + 1;
            int playerCard2 = random.nextInt(10) + 1;
            int playerTotal = playerCard1 + playerCard2;

            int dealerTotal = dealerCard1 + dealerCard2;
            System.out.println("Dealer shows one card: " + dealerCard1);

            System.out.println("Players Cards: " + playerCard1 + " " + playerCard2);
            System.out.println("Players Total: " + playerTotal);

            System.out.println("Hit; yes or no?");
            String card3 = input.nextLine();

            while(card3.equalsIgnoreCase("yes")) {

                card3 = random.nextInt(10) + 1;
                playerTotal += card3;
                System.out.println("Next card: " + card3);
                System.out.println("Player total: " + playerTotal);

                if (playerTotal > 21) {
                    System.out.println("Busted! Dealer wins this game");
                    System.out.println("Would you like to play agian; yes or no?");
                    String playerAgain = input.nextLine();
                }
                if (playerTotal < 21) {
                    System.out.println("Hit; yes or no?");
                    String card3 = input.nextLine();
                }
            }

        }

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
