import java.util.Scanner;

import cd.rr.blackjack.Card;
import cd.rr.blackjack.Deck;
import java.util.ArrayList;
import cd.rr.blackjack.CardENUM;

public class User {

    Deck Hand;
    Deck PlayerHand;



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Which option would you like to choose: hit, split, double, or stand? ")
        String optionChecker = input.next();
        char o = optionChecker.charAt(0);

        switch (o) {
            case 'h':
                System.out.println("Hit!");
                break;
            case 'p':
                System.out.println("Split!");
                break;
            case 'd':
                System.out.println("Double");

                break;
            case 's':
                System.out.println("Stand!");
                break;
            default:
                System.out.println("No option was chosen");
                break;
        }
    }

    public Deck getHand(){
        return Hand;
    }

    //    method to view first card
    public static void viewFirstCard(Card Hand){
        return Hand[0];
    }
//    public static void viewPlayersHand(PlayerHand){
//        return Playerhand[0,1];
//    }

    public static void hit(Deck dealerHand){
        return Hand[1];
    }

    public static void split(Card){
        return Card;
    }

    public static double betDouble(){
        return bets * 2;
    }

    public static void stand(Deck playerHand){

    }

}
