package com.finn.game;

import java.io.IOException;

import com.finn.model.Deck;
import com.finn.model.Player;
import com.finn.util.Util;

/**
 * Class representing the main program for Blackjack game.
 */
public class Game {

	public static void main(String[] args) throws IOException {

		Deck deck;
		boolean fileExists = Util.isFileProvided(args);

		if (fileExists) {
			deck = new Deck(Util.buildCardListFromFileContent(args[0]));
		} 
		else {
			deck = new Deck();
			deck.populateDeckOfCards();
			deck.shuffle();
		}

		Player sam = new Player();
		Player dealer = new Player();
		BlackJack blackJack = new BlackJack();

		boolean samWins = blackJack.playGame(deck, sam, dealer);

		if (samWins) {
			blackJack.printOutput("sam", sam, dealer);
		}

		else {
			blackJack.printOutput("dealer", sam, dealer);
		}

	}


}
