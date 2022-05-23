package com.leetcode;

public class Blanagrams {

	public static void main(String[] args) {
		System.out.println("result:" + checkBlanagrams("anagream", "tangram"));
	}

	public static boolean checkBlanagrams(String word1, String word2) {
		int len;
		int[] lenarray = new int[26];
		if (word1.length() != word2.length()) {
			return false;
		}

		for (int i = 0; i < word1.length(); i++) {

			lenarray[word1.charAt(i) - 'a']++;
			lenarray[word2.charAt(i) - 'a']--;
			System.out.println(word1.charAt(i) + " " + word2.charAt(i));
			System.out.println(word1.charAt(i) - 'a');
			System.out.println(word2.charAt(i) - 'a');
		}

		int str = 0;
		for (int i : lenarray) {
			str += Math.abs(i);
		}
		return str == 2;
	}

}
