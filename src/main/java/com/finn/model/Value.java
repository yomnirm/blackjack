package com.finn.model;

/**
 * Enum representing the possible values a card has.
 */
public enum Value {

	TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), 
	FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), 
	EIGHT(8, "8"), NINE(9,"9"), TEN(10, "10"),
	JACK(10, "J"), KING(10, "K"), QUEEN(10, "Q"), 
	ACE(11, "A");

	private final int value;
	private final String text;

	/**
	 * Constructor for Value enum
	 * 
	 * @param value
	 * @param text
	 */
	private Value(int value, String text) {
		this.value = value;
		this.text = text;
	}

	/**
	 * Returns the string text of the enum
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Returns the int value of the enum
	 * 
	 * @return value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns a corresponding value enum for a given string value
	 * 
	 * @param str
	 * @return value
	 */
	public static Value getValue(String str) {

		Value value = null;
		switch (str) {
		case "2":
			value = Value.TWO;
			break;

		case "3":
			value = Value.THREE;
			break;

		case "4":
			value = Value.FOUR;
			break;

		case "5":
			value = Value.FIVE;
			break;

		case "6":
			value = Value.SIX;
			break;

		case "7":
			value = Value.SEVEN;
			break;

		case "8":
			value = Value.EIGHT;
			break;

		case "9":
			value = Value.NINE;
			break;

		case "10":
			value = Value.TEN;
			break;

		case "K":
			value = Value.KING;
			break;

		case "Q":
			value = Value.QUEEN;
			break;

		case "J":
			value = Value.JACK;
			break;

		case "A":
			value = Value.ACE;
			break;

		default:
			throw new IllegalArgumentException("Invalid Value argument: " + str);

		}

		return value;
	}
}
