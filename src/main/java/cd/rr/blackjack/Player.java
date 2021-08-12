package cd.rr.blackjack;

public class Player {
    int totalChip;
    int bet;
    String name;
    int score;
    int splitScore;



    public int getBet() {
        return bet;
    }
    public void addBet(int addedBet) {
        bet+= addedBet;
    }

    public int getTotalChip() {
        return totalChip;
    }

    public void setTotalChip(int chips) {
        totalChip = chips;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }




    public boolean placeBet(int newBet){
        if (newBet > totalChip) {
            System.out.println("Not enough chips.");
            return false;
        }
        else {
            totalChip -= newBet;
            bet = newBet;
            return true;
        }
    }

}
