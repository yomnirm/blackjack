package com.finn.model;

/**
 * Enum representing the possible suits a card has.
 */
public enum Suit {

	CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");

	private final String suitText;

	/**
	 * Constructor for Suit enum
	 * 
	 * @param suitText
	 */
	private Suit(String suitText) {
		this.suitText = suitText;
	}

	/**
	 * Returns the suit text value
	 * 
	 * @return suit text
	 */
	public String getText() {

		return suitText;
	}

	/**
	 * Returns a corresponding suit enum for a given string value
	 * 
	 * @param str
	 * @return suit
	 */
	public static Suit getSuit(String str) {

		Suit suit = null;
		switch (str) {
		case "C":
			suit = Suit.CLUBS;
			break;

		case "D":
			suit = Suit.DIAMONDS;
			break;

		case "H":
			suit = Suit.HEARTS;
			break;

		case "S":
			suit = Suit.SPADES;
			break;

		default:
			throw new IllegalArgumentException("Invalid Suit argument: " + str);

		}

		return suit;
	}

}
