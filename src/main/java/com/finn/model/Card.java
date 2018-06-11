package com.finn.model;

/**
 * Class representing a playing card
 */
public class Card {

	private final Suit suit;
	private final Value value;
	
	/**
	 * Constructor for Card class
	 * 
	 * @param suit
	 * @param value
	 */
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	
	/**
	 * Returns the suit of a card
	 * @return suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Returns the value of a card
	 * @return value
	 */
	public Value getValue() {
		return value;
	}

	@Override
	public String toString() {
		return getSuit().getText() + getValue().getText();
		
	}
	
}
