package cd.rr.blackjack;

import java.util.ArrayList;
import java.util.Iterator;

public class Hand{
    public ArrayList<Card> hand;

    Hand() {
        this.hand = new ArrayList<Card>(11);

        Iterator<Card> cardIterator = hand.iterator();
        while (cardIterator.hasNext()) {
            Card aCard = (Card) cardIterator.next();

        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

}
