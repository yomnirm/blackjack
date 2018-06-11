package com.finn.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class representing a player of the Blackjack game.
 */
public class Player {
	
	private List<Card> cards;
	private final int BLACKJACK = 21;
	
	/**
	 * Constructor for Player class
	 */
	public Player() {
		cards = new ArrayList<Card>();
	}
	
	/**
	 * Adds a card to the list of Cards
	 * @param card card to be added to the list
	 */
	public void drawCard(Card card) {
		if(null != card) {
			cards.add(card);
		}
	}
    
	/**
	 * Returns the total score of the cards in hand
	 * @return total score
	 */
	public int getTotalScore() {
		
		return !cards.isEmpty() ? cards.stream().mapToInt(card -> card!= null ? card.getValue().getValue() : 0).sum() : 0;
	}
	
	/**
	 * Checks for a blackjack score of 21
	 * @return true if the total score is 21
	 */
	public boolean hasBlackJack() {
		
		return getTotalScore() == BLACKJACK;
	}
	
	@Override
	public String toString() {
		
		return cards.stream().map(card -> card.getSuit().getText() + card.getValue().getText()).collect(Collectors.joining(", "));
	}
}
