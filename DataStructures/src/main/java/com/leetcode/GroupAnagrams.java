/**
 * 
 */
package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Manoj
 *
 */
public class GroupAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] input = new String[]{"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result = groupAnagrams(input);

	}
	
	/**
	 * We will solve this by using a hashmap containing key as sorted string 
	 * and value as a list of strings which are identical to the key.
	 * If a new string taken and then sorted, is in the key of the hashmap
	 * we will update it in the list of values for that key
	 * Finally convert that hashmap to List<List<String>
	 */
	private static List<List<String>> groupAnagrams(String[] strs) {
		
		Map<String, List<String>> output = new HashMap<String, List<String>>();
		for(String input:strs) {
			char[] temp = input.toCharArray();
			Arrays.sort(temp);
			
		}
		
		return null;
	}

}


/*
this is a two player card game
the game starts with a deck of 52 cards represented as unique integers [1...52]
the cards are randomly shuffled and then dealt out to both players evenly
on each turn:
both players turn over their top-most card
the player with the higher valued card takes the cards and puts them in their scoring pile (scoring 1 point per card)
this continues until all the players have no cards left
the player with the highest score wins
if they have the same number of cards in their win pile, tiebreaker goes to the player with the highest card in their win pile

list of 52 numbers
from this list -> random class -> each of the players will get 26 cards Random nextInt()
Stack here datastructures a, b
 int point a and point b
String winplayer = a or b
one by one from both the list - 
    compare them - whoeever has greater value - increments their points 
    check for card with 52 value - update the string with player name

whoever has the higher value wins
else 
    if point a and point b is the same 
    return the winplayer 
       
*/