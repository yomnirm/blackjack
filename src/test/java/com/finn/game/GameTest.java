package com.finn.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.finn.game.BlackJack;
import com.finn.model.Card;
import com.finn.model.Deck;
import com.finn.model.Player;
import com.finn.model.Suit;
import com.finn.model.Value;

public class GameTest {
	
	private  Player sam;
	private  Player dealer;
	private  List<Card> deckCards;
	private  BlackJack blackJack = new BlackJack();
	
	@Before 
	public void setUp() {	
	   
		deckCards = new ArrayList<>();
		sam = new Player();
		dealer = new Player();
		
	 }

	@Test
	public void testInitialBlackJackForSam() {
		
		deckCards.add(new Card(Suit.CLUBS, Value.ACE));
		deckCards.add(new Card(Suit.DIAMONDS, Value.FIVE));
		deckCards.add(new Card(Suit.HEARTS, Value.JACK));
		deckCards.add(new Card(Suit.SPADES, Value.TWO));
		
		Deck deck = new Deck(deckCards);
		
		assertTrue("sam wins", blackJack.playGame(deck, sam, dealer));
		
	}
	
	@Test
	public void testInitialBlackJackForDealer() {
		
		deckCards.add(new Card(Suit.CLUBS, Value.SIX));
		deckCards.add(new Card(Suit.DIAMONDS, Value.ACE));
		deckCards.add(new Card(Suit.HEARTS, Value.JACK));
		deckCards.add(new Card(Suit.SPADES, Value.QUEEN));
		
		Deck deck = new Deck(deckCards);
		
		assertFalse("dealer wins", blackJack.playGame(deck, sam, dealer));
		
	}
	
	@Test
	public void testInitialBlackJackForBoth() {
		
		deckCards.add(new Card(Suit.CLUBS, Value.JACK));
		deckCards.add(new Card(Suit.DIAMONDS, Value.ACE));
		deckCards.add(new Card(Suit.HEARTS, Value.ACE));
		deckCards.add(new Card(Suit.SPADES, Value.KING));
		
		Deck deck = new Deck(deckCards);
		
		assertTrue("sam wins", blackJack.playGame(deck, sam, dealer));
		
	}
	
	@Test
	public void testInitialTwentyTwoForBoth() {
		
		deckCards.add(new Card(Suit.CLUBS, Value.ACE));
		deckCards.add(new Card(Suit.DIAMONDS, Value.ACE));
		deckCards.add(new Card(Suit.HEARTS, Value.ACE));
		deckCards.add(new Card(Suit.SPADES, Value.ACE));
		
		Deck deck = new Deck(deckCards);
		
		assertFalse("dealer wins", blackJack.playGame(deck, sam, dealer));
		
	}
	
	@Test
	public void testSamForHigherThanTwentyOne() {
		
		deckCards.add(new Card(Suit.CLUBS, Value.SIX));
		deckCards.add(new Card(Suit.DIAMONDS, Value.FIVE));
		deckCards.add(new Card(Suit.HEARTS, Value.NINE));
		deckCards.add(new Card(Suit.HEARTS, Value.QUEEN));
		deckCards.add(new Card(Suit.SPADES, Value.SEVEN));
		
		Deck deck = new Deck(deckCards);
		
		assertFalse("dealer wins", blackJack.playGame(deck, sam, dealer));
		
	}
	
	@Test
	public void testDealerForHigherThanTwentyOne() {
		
		deckCards.add(new Card(Suit.CLUBS, Value.SIX));
		deckCards.add(new Card(Suit.DIAMONDS, Value.FIVE));
		deckCards.add(new Card(Suit.HEARTS, Value.NINE));
		deckCards.add(new Card(Suit.HEARTS, Value.QUEEN));
		deckCards.add(new Card(Suit.SPADES, Value.FOUR));
		deckCards.add(new Card(Suit.CLUBS, Value.EIGHT));
		
		Deck deck = new Deck(deckCards);
		
		assertTrue("sam wins", blackJack.playGame(deck, sam, dealer));
		
	}
	
	@Test
	public void testForHighestScore() {
		
		deckCards.add(new Card(Suit.CLUBS, Value.SIX));
		deckCards.add(new Card(Suit.DIAMONDS, Value.FIVE));
		deckCards.add(new Card(Suit.HEARTS, Value.NINE));
		deckCards.add(new Card(Suit.HEARTS, Value.QUEEN));
		deckCards.add(new Card(Suit.SPADES, Value.FOUR));
		deckCards.add(new Card(Suit.CLUBS, Value.FIVE));
		
		Deck deck = new Deck(deckCards);
		
		assertFalse("dealer wins", blackJack.playGame(deck, sam, dealer));
		
	}
	
	@Test
	public void testWhenBothPlayersStartWithSameScore() {
		
		deckCards.add(new Card(Suit.CLUBS, Value.QUEEN));
		deckCards.add(new Card(Suit.DIAMONDS, Value.TEN));
		deckCards.add(new Card(Suit.HEARTS, Value.KING));
		deckCards.add(new Card(Suit.HEARTS, Value.JACK));
		deckCards.add(new Card(Suit.SPADES, Value.FOUR));
		deckCards.add(new Card(Suit.CLUBS, Value.FIVE));
		
		Deck deck = new Deck(deckCards);
		
		assertTrue("sam wins", blackJack.playGame(deck, sam, dealer));
		
	}
	
	@Test
	public void testWhenSamHasSeventeenInitally() {
		
		deckCards.add(new Card(Suit.CLUBS, Value.ACE));
		deckCards.add(new Card(Suit.DIAMONDS, Value.EIGHT));
		deckCards.add(new Card(Suit.HEARTS, Value.SIX));
		deckCards.add(new Card(Suit.HEARTS, Value.QUEEN));
		deckCards.add(new Card(Suit.SPADES, Value.TWO));
		
		Deck deck = new Deck(deckCards);
		
		assertFalse("dealer wins", blackJack.playGame(deck, sam, dealer));
		
	}
	
	@Test
	public void testGame() {
		
		deckCards.add(new Card(Suit.CLUBS, Value.ACE));
		deckCards.add(new Card(Suit.DIAMONDS, Value.FIVE));
		deckCards.add(new Card(Suit.HEARTS, Value.NINE));
		deckCards.add(new Card(Suit.HEARTS, Value.QUEEN));
		deckCards.add(new Card(Suit.SPADES, Value.EIGHT));
		
		Deck deck = new Deck(deckCards);
		
		assertTrue("sam wins", blackJack.playGame(deck, sam, dealer));
		
	}


}
