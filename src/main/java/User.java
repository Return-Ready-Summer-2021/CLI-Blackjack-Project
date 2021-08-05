import java.util.Scanner;

public class User {

    Deck Hand;
    Deck PlayerHand;

    Scanner input = new Scanner(System.in);

    System.out.println("Which option would you like to choose: hit, split, double, or stand? ")
    String optionChecker = input.next();
    char o = optionChecker.charAt(0,1);

    switch (o) {
        case "hi":
            System.out.println("Hit!");
            break;
        case "sp":
            System.out.println("Split!");
            break;
        case "do":
            System.out.println("Double");

            break;
        case "st":
            System.out.println("Stand!");
            break;
        default:
            System.out.println("No option was chosen");
            break;
    }

    public Card getHand(){
        return hand;
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

    public static void double(){
        return bets * 2;
    }

    public static void stand(Deck playerHand){

    }

}
