package cd.rr.blackjack;

public class CardENUM {
    public enum Rank {
        ACE(14),
        KING(13),
        QUEEN(12),
        JACK(11),
        TEN(10),
        NINE(9),
        EIGHT(8),
        SEVEN(7),
        SIX(6),
        FIVE(5),
        FOUR(4),
        THREE(3),
        TWO(2);

        private final int Rank;

        Rank(int value) {
            this.Rank = value;
        }

        public int getRank() {
            return Rank;
        }
    }

    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }
}
