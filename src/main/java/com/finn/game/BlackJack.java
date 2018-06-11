package com.finn.game;

import com.finn.model.Deck;
import com.finn.model.Player;

/**
 * Class providing for operational methods for the BlackJack game.
 */
public class BlackJack {

	/**
	 * Determines the winner of blackjack game.
	 * Returns true if player sam wins, false otherwise
	 * 
	 * @param deck playing deck of 52 cards
	 * @param sam player of the game
	 * @param dealer dealer of the game
	 * @return boolean value, true if player wins or false if dealer wins
	 */
	public boolean playGame(Deck deck, Player sam, Player dealer) {

		boolean flag = false;
		drawInitialCards(deck, sam, dealer);
        
		// CASE#1 : only sam has BlackJack
		if (ifEitherPlayerHasBlackJack(sam, dealer)) {
			return true; // sam wins
		}

		// CASE#2 : only dealer has BlackJack
		if (ifEitherPlayerHasBlackJack(dealer, sam)) {
			return false; // dealer wins
		}
		
		// CASE#3 : when both players starts with Blackjack
		if (ifBothPlayersHaveBlackJack(sam, dealer)) {
			return true; // sam wins
		}

		// CASE#4 : when both players start with 22
		if (ifBothPlayersStartWithTwentyTwo(sam, dealer)) {
			return false; // dealer wins
		}

		// CASE#5
		else {

			flag = continueGame(deck, sam, dealer);
		}

		return flag;
	}

	/**
	 * Checks if only one of the players has an initial blackjack
	 * 
	 * @param playerOne 
	 * @param playerTwo
	 * @return true if only playerOne has a blackjack, false otherwise
	 */
	private boolean ifEitherPlayerHasBlackJack(Player playerOne, Player playerTwo) {

		return playerOne.hasBlackJack() && !playerTwo.hasBlackJack();

	}

	/**
	 * Determines the winner of blackjack game after checking the initial conditions.
	 * Returns true if player wins, false otherwise
	 * 
	 * @param deck playing deck of cards
	 * @param sam player of the game
	 * @param dealer dealer of the game
	 * @return boolean value, true if player wins or false if dealer wins
	 */
	private boolean continueGame(Deck deck, Player sam, Player dealer) {

		// sam starts drawing
		while (sam.getTotalScore() < 17) {

			sam.drawCard(deck.dealCard());
		}

		if (sam.hasBlackJack()) 
			return true;  // sam wins

		if (sam.getTotalScore() > 21)
			return false; // sam looses

		// dealer starts drawing
		while (!(dealer.getTotalScore() > sam.getTotalScore())) { 
			
			dealer.drawCard(deck.dealCard());
		}

		if (dealer.hasBlackJack()) 
			return false; // dealer wins

		if (dealer.getTotalScore() > 21) 
			return true; // dealer looses

		
		return sam.getTotalScore() > dealer.getTotalScore();

	}

	/**
	 * Checks if both players have a score of 22
	 * 
	 * @param sam player of the game
	 * @param dealer dealer of the game
	 * @return true if both players have a score of 22, false otherwise
	 */
	private boolean ifBothPlayersStartWithTwentyTwo(Player sam, Player dealer) {

		return (sam.getTotalScore() == 22 && dealer.getTotalScore() == 22) ? true : false;
	}
	
	/**
	 * Checks if both players have blackjack
	 * 
	 * @param sam player of the game
	 * @param dealer dealer of the game
	 * @return true if both players have blackjack, false otherwise
	 */
	private boolean ifBothPlayersHaveBlackJack(Player sam, Player dealer) {

		return (sam.hasBlackJack() && dealer.hasBlackJack()) ? true : false;
	}

	/**
	 * Provides two cards to each player from the top of deck of cards.
	 * Cards are given in the following order: [sam, dealer, sam, dealer]
	 * 
	 * @param deck playing deck of 52 cards
	 * @param sam player of the game
	 * @param dealer dealer of the game
	 */
	private void drawInitialCards(Deck deck, Player sam, Player dealer) {

		sam.drawCard(deck.dealCard());
		dealer.drawCard(deck.dealCard());
		sam.drawCard(deck.dealCard());
		dealer.drawCard(deck.dealCard());

	}

	/**
	 * Prints the output of the game.
	 * 
	 * @param winner String representing the winner
	 * @param sam player of the game
	 * @param dealer dealer of the game
	 */
	public void printOutput(String winner, Player sam, Player dealer) {

		System.out.println(winner);
		System.out.println("sam: " + sam);
		System.out.println("dealer: " + dealer);

	}

}
