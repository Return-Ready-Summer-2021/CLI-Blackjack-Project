public class Dealer {
    Card card;
    Hand hand = new Hand();
    int users;
    Player[] players;


    public void addCard(Card card){
        hand.addCard(card);
    }
    public boolean isBlackJack(){
        return hand.calculateTotal() == 21;
    }
    public int calculateTotal(){
        return hand.calculateTotal();
    }
    public void dealCards(){
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < users; i++) {
                players[i].addCard(deck.nextCard());
            }
            dealer.addCard(deck.nextCard());
        }
    }



//    Use for array of cards
//    Deck[];
//    DealerHand[];
}