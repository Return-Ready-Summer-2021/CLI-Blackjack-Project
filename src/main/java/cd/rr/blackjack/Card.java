package cd.rr.blackjack;

import cd.rr.blackjack.CardENUM.*;

public class Card {

     private Suit suit;
     private Rank rank;

     Card() {}


    public Card(Suit s, Rank r) {
        suit = s;
        rank = r;
    }
    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}
