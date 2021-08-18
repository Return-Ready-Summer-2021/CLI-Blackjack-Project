package cd.rr.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import cd.rr.blackjack.CardENUM.*;


public class Deck {
    public ArrayList<Card> deck;


    public Deck() {
        this.deck = new ArrayList<Card>(52);
        for (int i = 0; i < 13; i++) {
            Rank rank = Rank.values()[i];
            for (int j = 0; j < 4; j++) {
                Card card = new Card(Suit.values()[j], rank);
                this.deck.add(card);

            }
        }

        Collections.shuffle(deck);

        Iterator<Card> cardIterator = deck.iterator();
        while (cardIterator.hasNext()) {
            Card aCard = (Card) cardIterator.next();

        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }


    public Card getDeck(int i) {
        return deck.get(i);
    }
}
