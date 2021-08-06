

public class Hand {
    int numOfCards = 0;
    Card[] theHand = new Card[11];

    public void addCard(Card card){
        theHand[numOfCards++] = card;
    }
    public int calculateTotal() {
        int total =0;
        boolean aceFlag = false;
        for (int i = 0; i < numOfCards; i++) {
            int value = theHand[i].getValue();
            if (value > 10) {
                value = 10;
            } else if ( value == 1) {
                aceFlag = true;
            }
            total += value;
        }
        if (aceFlag && total + 10 <= 21) {
            total += 10;
        }
        return total;
    }





}
