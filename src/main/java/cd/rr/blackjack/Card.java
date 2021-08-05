package cd.rr.blackjack;

import cd.rr.blackjack.CardENUM.*;

class Card {

    // use switch case for rank

     private Suit suit;
     private Rank rank;


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
        return suit + " :: " + rank;
    }
}
