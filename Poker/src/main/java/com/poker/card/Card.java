package main.java.com.poker.card;

/**
 * A standard poker-style playing card without jokers.
 * Four suits (Hearts, Diamonds, Clubs and Spades) and thirteen ranks (Ace, 2-10, Jack, Queen, and King).  
 */
public class Card {
	
	public enum SUITS {HEARTS(0), DIAMONDS(1), CLUBS(2), SPADES(3);
		private int ordinal;
		 
		private SUITS(int ordinal) {
			this.ordinal = ordinal;
		}
	
		public int getOrdinal() {
			return ordinal;
		}
	}
	
	public enum RANKS{ACE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13);
		private int ordinal;
	 
		private RANKS(int ordinal) {
			this.ordinal = ordinal;
		}
 
		public int getOrdinal() {
			return ordinal;
		}
	}
	
	private int suit;
	private int rank;
	private RANKS ranks;
	private SUITS suits;
	
	public Card(RANKS ranks, SUITS suits) {
		this.suits = suits;
		this.suit =  suits.getOrdinal();
		this.ranks = ranks;
		this.rank = ranks.getOrdinal();
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	public RANKS getRanks() {
		return ranks;
	}

	public SUITS getSuits() {
		return suits;
	}

	@Override
	public String toString() {
		return "Card [suit=" + suits + "(" + suit + "), rank=" + ranks + "(" + rank +")]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + suit;
		result = prime * result + rank;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (suits != other.suits)
			return false;
		if (ranks != other.ranks)
			return false;
		return true;
	}
	
}
