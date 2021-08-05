package cd.rr.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import cd.rr.blackjack.CardENUM.*;


public class Deck {
    public ArrayList<Card> deck;


    public Deck() {
        this.deck = new ArrayList();
        for (int i = 0; i < 13; i++) {
            Rank rank = Rank.values()[i];
            for (int j = 0; j < 4; j++) {
                Card card = new Card(Suit.values()[j], rank);
                this.deck.add(card);

            }
        }
        Collections.shuffle(deck);

        Iterator cardIterator = deck.iterator();
        while (cardIterator.hasNext()) {
            Card aCard = (Card) cardIterator.next();

        }

    }
}
