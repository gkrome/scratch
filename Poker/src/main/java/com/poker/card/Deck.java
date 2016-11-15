package main.java.com.poker.card;


import java.util.Arrays;
import java.util.Random;

/**
 * A standard deck of 52 cards.
 * 
 */
public class Deck {
	
	private static final int SIZE = Card.RANKS.values().length * Card.SUITS.values().length;
	private Card[] deck;
	private Random randomNumberGenerator = null;
	private int numberOfCardsLeft = SIZE;
	private int currentCard = 0;
	
	/**
	 * 
	 * Creates a deck of 52 cards.
	 * */
	public Deck(){
		randomNumberGenerator = new Random();
		deck = new Card[SIZE];
		init();
	}
		
	/**
	 * Deal one card from Deck without shuffling between dealt.
	 * @return a Card from the Deck
	 * @throws Exception 
	 */
	public Card deal_one_card() throws Exception{
		Card card = null;
		if (numberOfCardsLeft > 0 && currentCard < deck.length) {
			numberOfCardsLeft = numberOfCardsLeft - 1;
			card = deck[currentCard++];
		} else {
			throw new Exception("No more card in deck");
		}
		return card;
	}
	
    /**
     * Shuffle the deck by randomly swapping cards.
     */
    public void shuffle() {
    	
        for ( int current = 0; current < deck.length; current++ ) {
        	// select a random number between 0 and (SIZE - 1)
        	int random =  randomNumberGenerator.nextInt(SIZE);
        	// randomly select a card and swap it         	
        	Card temp = deck[current];        
        	// swap current Card with randomly selected Card
        	deck[current] = deck[random];   
        	deck[random] = temp;
        }
         
        //card on top of the deck
        //no cutting of the deck
        currentCard = 0;
        numberOfCardsLeft = deck.length;
    }

    /**
     * Returns the number of cards that are still left in the deck. 
     * It decreases by 1 each time the deal_one_card() method is called.
     * @return then number of cards that are left in the deck
     */
    public int numberOfCardsLeft() {
        return numberOfCardsLeft;
    }
    
    /**
     * Get the size of a full deck.
     * @return size of a deck
     */
    public int getSize() {
        return SIZE;
    }
    
    /**
     * Initializes the deck.
     */
    private void init() {
    	int ranksSize = Card.RANKS.values().length;
    	int suitsSize = Card.SUITS.values().length;
    	
        for (int i = 0; i < ranksSize; i++) {
            for (int j = 0; j < suitsSize; j++) {
                deck[(suitsSize*i) + j] = new Card(Card.RANKS.values()[i], Card.SUITS.values()[j]);
                //System.out.println((suitsSize*i) + j + " :" + deck[(suitsSize*i) + j]);
            }
        }
    }

	@Override
	public String toString() {
		return "Deck [deck=" + Arrays.toString(deck) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentCard;
		result = prime * result + Arrays.hashCode(deck);
		result = prime * result + numberOfCardsLeft;
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
		Deck other = (Deck) obj;
		if (currentCard != other.currentCard)
			return false;
		if (!Arrays.equals(deck, other.deck))
			return false;
		if (numberOfCardsLeft != other.numberOfCardsLeft)
			return false;
		return true;
	}
	
}
