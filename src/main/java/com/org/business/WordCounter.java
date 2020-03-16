package com.org.business;

import java.util.HashMap;

/** This is implementation of WordCounter as per test requirement.
 * 	It allows adding words in a store that pass the critetia
 *  It also allows printing count of a word and all word count
 * @author SBOKDE
 *
 */
public class WordCounter {

	public static HashMap<String, Integer> wordStore = new HashMap<>();

	
	
	public WordCounter() {
		wordStore = new HashMap<>();
	}

	/** method to add word in a store and return true if it is added successfully, false otherwise
	 * @param word
	 * @return
	 */
	public boolean addWord(String word) {
		
		//check for non-alphabetic characters
		if (word != null && !word.isEmpty() &&
				word.chars().allMatch(Character::isLetter)) {
				word = Translator.translate(word);
				
				if (wordStore.computeIfPresent(word, ( k, v) -> v+1)==null) {
					wordStore.put(word, 1);
				}
				return true;
		}
		else {
			return false;
		}
	}
	
	/** This method returns count of a word in store
	 * @param word
	 * @return
	 */
	public Integer getWordCount(String word) {
		return (null==wordStore.get(word)?0:wordStore.get(word));
	}
	
	/**
	 * Method to print all words from word store and their count
	 */
	public void getAllWords() {
		System.out.println();
		wordStore.entrySet().forEach(entry->{
		    System.out.println(entry.getKey() + " " + entry.getValue());  
		 });
	}
	
	/**
	 * clear down the store
	 * Not a requirement but I am adding it to be used with JUnit test
	 */
	public void clearWordStore () {
		wordStore.clear();
	}
}
