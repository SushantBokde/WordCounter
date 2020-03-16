package com.org.business;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordCounterTest {

	@Test
	public void testAddWordWithNullInput() {
		WordCounter counter = new WordCounter();
		assertFalse(counter.addWord(null));
	}
	
	@Test
	public void testAddWordWithEmptyInput() {
		WordCounter counter = new WordCounter();
		assertFalse(counter.addWord(""));
	}
	
	@Test
	public void testAddWordWithNonAlphabeticInput() {
		WordCounter counter = new WordCounter();
		assertFalse(counter.addWord("LE33ON"));
	}
	
	@Test
	public void testAdd1WordWithAlphabeticInput() {
		WordCounter counter = new WordCounter();
		assertTrue(counter.addWord("Success"));
	}

	@Test
	public void testWordCountWithBlankInput() {
		WordCounter counter = new WordCounter();
		assertSame(0,counter.getWordCount(""));
	}
	
	
	@Test
	public void testAddMultipleWordWithAlphabeticInput() {
		WordCounter counter = new WordCounter();
		assertTrue(counter.addWord("Success"));
		assertTrue(counter.addWord("Test"));
		assertTrue(counter.addWord("Repeat"));
		assertTrue(counter.addWord("Major"));
		assertTrue(counter.addWord("Time"));
		assertTrue(counter.addWord("Test"));
		assertTrue(counter.addWord("Repeat"));
		
		assertSame(1, counter.getWordCount("Success"));
		assertSame(2, counter.getWordCount("Test"));
		assertSame(2, counter.getWordCount("Repeat"));
		assertSame(1, counter.getWordCount("Major"));
		assertSame(1, counter.getWordCount("Time"));
	}
	
	//@Test
	public void testAddWordWithAlphabeticInputWithMockTranslator() {
		WordCounter counter = new WordCounter();
		counter.addWord("flower");
		counter.addWord("Flor");
	}
	
	@Test
	public void testWordCountWithNonExistingWordInStore() {
		WordCounter counter = new WordCounter();
		assertSame(0,counter.getWordCount("Random"));
	}
	
	@Test
	public void testWordCountWithExistingWordInStore() {
		WordCounter counter = new WordCounter();
		assertTrue(counter.addWord("Super"));
		assertTrue(counter.addWord("Super"));
		assertTrue(counter.addWord("Super"));
		assertSame(3,counter.getWordCount("Super"));
	}
	
//	@Test
//	public void testGetAllWordCount() {
//		WordCounter counter = new WordCounter();
//		counter.addWord("Success");
//		counter.addWord("Test");
//		counter.addWord("Repeat");
//		counter.addWord("Major");
//		counter.addWord("Time");
//		counter.addWord("Test");
//		counter.addWord("Repeat");
//		counter.getAllWords();
//	}
	
}
