package test.java.com.poker.card;

import main.java.com.poker.card.Card;
import main.java.com.poker.card.Card.RANKS;
import main.java.com.poker.card.Card.SUITS;

import org.junit.Test;

import junit.framework.TestCase;

public class CardTest extends TestCase{
	
	@Test
	public void testGetRanks() {
		Card card = new Card(RANKS.ACE, SUITS.CLUBS);
		assertEquals(RANKS.ACE, card.getRanks());
	}
	
	@Test
	public void testGetSuits() {
		Card card = new Card(RANKS.ACE, SUITS.CLUBS);
		assertEquals(SUITS.CLUBS, card.getSuits());
	}
}
