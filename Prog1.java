/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author Andy
 */
public class Prog1 {
    public static void main(String[] args) {
        Deck deck = new Deck();
        System.out.println(deck.toString());
        Hand hand = new Hand();
        while(hand.addCard(deck.dealCard()));
        System.out.println(hand.toString() + ": " + hand.game());
        deck.shuffle();
        System.out.println(deck.toString());
        hand = new Hand();
        while(hand.addCard(deck.dealCard()));
        System.out.println(hand.toString() + ": " + hand.game());
    }
}
