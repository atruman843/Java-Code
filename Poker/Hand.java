package poker;

public class Hand {
    Card[] hand = new Card[5];
    private int index = 0;
    public boolean addCard(Card card) {
        if (index < hand.length) {
            hand[index] = card;
            index++;
            return true;
        }
        return false;
    }
    
    public Card lookup(int n) {
        return hand[n];
    }
    
    public boolean replace(int n, Card card) {
        if (n < hand.length) {
            hand[n] = card;
            return true;
        }
        return false;
    }
    
    public Card[] orderRank() {
        Card hold = new Card(0,0);
        for (int i = 0; i < hand.length; i++) {
            for (int j = i; j < hand.length; j++) {
                if (hand[j].getRank() < hand[i].getRank()) {
                    hold = hand[i];
                    hand[i] = hand[j];
                    hand[j] = hold;
                }
            }
        }
        return hand;
    }
    
    public Card[] remove() {
        Card[] hand1 = new Card[5];
        for (int i = 0; i < hand1.length; i++) {
            hand1[i] = hand[i];
        }
        orderRank();
        int index = 0;
        int i = 0;
        while (true) {
            if (hand1[i].getRank() == hand1[i+1].getRank() && hand1[i].getRank() == hand1[i+2].getRank()) {
                hand1[i] = null;
                hand1[i+1] = null;
                hand1[i+2] = null;
                break;
            }
            else {
                hand1[index] = hand1[i];
                index++;
            }
            i++;
        }
        return hand1;
    }
    
    public boolean isOnePair() {
        for(int i = 0; i < hand.length; i++) {
            for (int j = 0; j < hand.length; j++) {
                if(i == j) {j++;}
                else if (hand[i].getRank() == hand[j].getRank()) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isTwoPair() {
        if (hand[0].getRank() == hand[1].getRank() || hand[1].getRank() == hand[2].getRank()) {
            if (hand[2].getRank() == hand[3].getRank() || hand[3].getRank() == hand[4].getRank()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isThreeOfAKind() {
        Card[] hand1 = orderRank();
        for (int i = 0; i < hand.length - 2; i++) {
            if (hand1[i].getRank() == hand1[i+2].getRank()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isStraight() {
        Card[] hand1 = orderRank();
        for(int i = 0; i < hand1.length; i++) {
            if (i + 1 < hand1.length) {
                if (hand1[i].getRank() + 1 != hand1[i + 1].getRank()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isFlush() {
        for(int i = 0; i < hand.length; i++) {
            if (i + 1 < hand.length) {
                if (hand[i].getSuit() != hand[i + 1].getSuit()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isFullHouse() {
        if (isThreeOfAKind()) {
            remove();
            if (hand[0].getRank() != hand[1].getRank()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isFourOfAKind() {
        Card[] hand1 = orderRank();
        if (hand1[0].getRank() == hand1[3].getRank() || hand[1].getRank() == hand[4].getRank()) {
            return true;
        }
        return false;
    }
    
    public boolean isStraightFlush() {
        if (isStraight()) {
            if (isFlush()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isRoyalFlush() {
        Card[] hand1 = orderRank();
        if (hand1[0].getRank() == 8 && isStraightFlush()) {
            return true;
        }
        return false;
    }
    
    public String game() {
        if (isRoyalFlush()) {
            return "ROYALFLUSH";
        }
        else if (isStraightFlush()) {
            return "STRAIGHTFLUSH";
        }
        else if (isFourOfAKind()) {
            return "FOUROFAKIND";
        }
        else if (isFullHouse()) {
            return "FULLHOUSE";
        }
        else if (isFlush()) {
            return "FLUSH";
        }
        else if (isStraight()) {
            return "STRAIGHT";
        }
        else if (isThreeOfAKind()) {
            return "THREEOFAKIND";
        }
        else if (isTwoPair()) {
            return "TWOPAIR";
        }
        else if (isOnePair()) {
            return "ONEPAIR";
        }
        else {
            return "NOTHING";
        }
    }
    
    @Override
    public String toString() {
        String handString = "";
        for (int i = 0; i < hand.length; i++) {
            handString += (hand[i].toString() + " ");
        }
        return handString;
    }
}
