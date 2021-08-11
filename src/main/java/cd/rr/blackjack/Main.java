package cd.rr.blackjack;


import java.util.Scanner;

public class Main extends BJS {




    public static void main(String[] args) {
        BJS BJ = new BJS();


        BJ.startDeal();
//        BJ.viewDealerHand();

//        BJ.optionChecker();
        // testing
        System.out.println(BJ.playerHand.getHand());
        System.out.println(BJ.bjDeck.deck.size());
        System.out.println(BJ.getScore());











//        System.out.println("        Welcome to BlackJack!      ");
//        System.out.println("---------------------------------------");
//        System.out.println("          Here are the rules          ");
//        System.out.println("1. Each player starts with two cards, one of the dealer's cards is hidden until the end.");
//        System.out.println("2. To 'Hit' is to ask for another card. To 'Stand' is to hold your total and end your turn.");
//        System.out.println("3. If you go over 21 you bust, and the dealer wins regardless of the dealer's hand.");
//        System.out.println("4. cd.rr.blackjack.Dealer will hit until his/her cards total 17 or higher.");
//        System.out.println("5. Doubling is like a hit, only the bet is doubled and you only get one more card.");
//        System.out.println("6. Split can be done when you have two of the same card - the pair is split into two hands.");
//        System.out.println("7. You can only double/split on the first move, or first move of a hand created by a split.");
//        System.out.println("8. The goal of blackjack is to beat the dealer's hand without going over 21.");
//        System.out.println("9. Face cards are worth 10. Aces are worth 1 or 11, whichever makes a better hand.");
    }
}
