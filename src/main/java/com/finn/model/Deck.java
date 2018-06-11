package com.finn.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing the deck of playing cards
 */
public class Deck {

	private final List<Card> deckCards;
	
	/**
	 * Constructor for Deck class
	 */
	public Deck() {
		deckCards = new ArrayList<Card>(52);
	}
	
	/**
	 * Parameterized Constructor for Deck class
	 * 
	 * @param deckOfCards list of cards
	 */
	public Deck(List<Card> deckOfCards) {
		deckCards = deckOfCards;
	}

	/**
	 * Populates the deck with 52 cards
	 */
	public void populateDeckOfCards() {
		
		for(Suit suits : Suit.values()) {
			for(Value value : Value.values()) {
				deckCards.add(new Card(suits, value));
			}
		}
	}
	
	/**
	 * Shuffles the cards in a deck
	 */
	public void shuffle() {
		Collections.shuffle(deckCards);
	}
	
	/**
	 * Removes a card from the top of the deck of playing cards
	 * @return card
	 */
	public Card dealCard() {

		return !deckCards.isEmpty() ? deckCards.remove(0) : null;
	}
	
	// REMOVE
	public void displayCards() {
		
		System.out.println("Deck: " + deckCards.size() + "-"+ deckCards);
	}

	
}
