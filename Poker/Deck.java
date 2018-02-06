package poker;


import java.util.Random;
public class Deck {
    private Card[] deck = new Card[52];
    private int index = 0;
    
    public Deck() {
        for(int i = 0; i < deck.length; i++) {
            deck[i] = new Card(i / 13, i % 13);
        }
    }
    public void shuffle() {
        Card holder = new Card(0,0);
        for(int i = 0; i < 100; i++) {
            Random n = new Random();
            int rand = n.nextInt(51) + 1;
            holder = deck[0];
            deck[0] = deck[rand];
            deck[rand] = holder;
        }
        index = 0;
    }
    
    public Card dealCard() {
        Card card = deck[index];
        index++;
        return card;
    }
    
    public int getCardsRemaining() {
        return (deck.length - index);
    }
    
    @Override
    public String toString() {
        String deckRemaining = "";
        for (int i = index; i < deck.length; i++) {
            deckRemaining += deck[i].toString() + " ";
            
        }
        return deckRemaining;
    }
}
