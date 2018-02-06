package poker;

public class Card {
    private int suit;
    private int rank;
    
    public static final int CLUBS = 0;
    public static final int HEARTS = 1;
    public static final int SPADES = 2;
    public static final int DIAMONDS = 3;
    
    public static final int TWO = 0;
    public static final int THREE = 1;
    public static final int FOUR = 2;
    public static final int FIVE = 3;
    public static final int SIX = 4;
    public static final int SEVEN = 5;
    public static final int EIGHT = 6;
    public static final int NINE = 7;
    public static final int TEN = 8;
    public static final int JACK = 9;
    public static final int QUEEN = 10;
    public static final int KING = 11;
    public static final int ACE = 12;

    private static String[] suitName = {"C", "H", "S", "D"};
    private static String[] rankName = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Card(int suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    public int getRank() {
        return rank;
    }
    
    public int getSuit() {
        return suit;
    }
    
    public String getRankName() {
        return rankName[rank];
    }
    
    public String getSuitName() {
        return suitName[suit];
    }
    
    @Override
    public String toString() {
        return (getRankName() + getSuitName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.suit != other.suit) {
            return false;
        }
        if (this.rank != other.rank) {
            return false;
        }
        return true;
    }  
}
