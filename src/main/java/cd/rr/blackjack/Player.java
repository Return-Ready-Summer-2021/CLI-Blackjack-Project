package cd.rr.blackjack;

import java.util.ArrayList;

public class Player {
    int totalChip;
    int bet;
    String name;
    int score;


    public int getBet() {
        return bet;
    }




    public void placeBet(int newBet){
        bet = newBet;
    }

}
