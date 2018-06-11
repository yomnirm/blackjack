package com.finn.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.finn.model.Card;
import com.finn.model.Suit;
import com.finn.model.Value;

/**
 * Util class providing utility methods for Black Game program.
 */
public class Util {
	
	/**
	 * Method to build list of card objects from the file content
	 * Deck of cards is in the following format: CA, D4, H7, SJ,…, S5, S9, D10
	 * 
	 * @param filePath reference to the file containing a deck of cards.
	 * @return list of card objects
	 * @throws IOException
	 */
	private static List<Card> buildCardList(String fileContent){
		
		List<Card> cardList = new ArrayList<>();
		String[] cards = fileContent.trim().replace(" ", "").split(",");
		
		for(String str : cards) {
			System.out.println("Incoming Card: " + str);
			System.out.println("After Split: " + str.substring(0, 1) + "-" + str.substring(1));
			Card card = new Card(Suit.getSuit(str.substring(0, 1)), Value.getValue(str.substring(1))); 
			cardList.add(card);
			System.out.println("Built Card Object: " + card);
		}
		
		System.out.println("Size of Deck: " + cardList.size());
		return cardList;
		
	}
	
    /**
     * Method to check if file path is provided as a command line argument to the program.
     * @param args command line argument to the program
     * @return true if argument contains value, false otherwise 
     */
	public static boolean isFileProvided(String[] args) {

		return null != args && args.length != 0 && !"".equals(args[0]);

	}
	
	/**
	 * Method to build list of card objects from the file content
	 * 
	 * @param filePath reference to the file containing a deck of cards.
	 * @return list of card objects
	 * @throws IOException
	 */
	public static List<Card> buildCardListFromFileContent(String filePath) throws IOException {
		
		String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
		System.out.println("FileContent : " + fileContent);
		return buildCardList(fileContent);
	}
	
 
	
}
