package main.java.com.poker.game;

import main.java.com.poker.card.Card;
import main.java.com.poker.card.Deck;


public class Dealer {
	public static void main(String[] args) {

		Deck deck = new Deck();
		deck.shuffle();
		for (int i = 0; i < deck.getSize() + 1; i++) {
			Card card = null;
			try {
				card = deck.deal_one_card();
			} catch (Exception e) {
				e.printStackTrace(System.out);
			} 
			System.out.println((i+1) + " : " + card);
		}
	}
}
