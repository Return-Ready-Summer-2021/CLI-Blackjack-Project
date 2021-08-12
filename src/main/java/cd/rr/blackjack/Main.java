package cd.rr.blackjack;


import java.util.Scanner;

public class Main extends BJS {




    public static void main(String[] args) {
        BJS BJ = new BJS();
        Scanner input = new Scanner(System.in);
        char playAgainChar;


//        BJ.startDeal();
//        BJ.viewDealerHand();

//        BJ.optionChecker();
        // testing
//        System.out.println(BJ.playerHand.getHand());
//        System.out.println(BJ.bjDeck.deck.size());
//        System.out.println(BJ.getScore());
        BJ.discardDeck.deck.clear();
        System.out.print("What is your name?: ");
        BJ.player.setName(input.nextLine());
        System.out.print("How many chips would you like to start with?: ");
        BJ.player.setTotalChip(input.nextInt());
        if (BJ.player.totalChip == 0) {
            System.out.println("You cant play with out any chips!");
            System.out.println("Come back when you have chips to spare.");
            System.exit(0);
        }
        System.out.println("\n\n");
        String playAgain;


        BJ.rules();
        BJS.wait(5000);
        do {
            if (BJ.player.totalChip == 0) {
                System.out.println("You have run out of chips!");
                System.out.println("Come back when You've got more!");
                System.exit(0);
            }
            System.out.println("\n\n");
            BJ.startDeal();
            BJ.optionChecker();
            BJ.dealerHit();
            BJ.scoreChecker();
            System.out.print("Would you like to play again?(y/n): ");

            playAgain = input.next();
            playAgainChar = playAgain.charAt(0);
            if (playAgainChar != 'y' && playAgainChar != 'n') {
                do {

                    System.out.println("Not an input stupid, try again");
                    playAgain = input.next();
                    playAgainChar = playAgain.charAt(0);
                } while ((playAgainChar != 'y' && playAgainChar != 'n'));
            }
            if (playAgainChar == 'y') {
                BJ.clearScore();
                BJ.clearHand();
                System.out.println("Reseting...");
                BJS.wait(2000);
            }


        }while (playAgainChar == 'y');
    }
}
