package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testDisplayWordWithGuessedLetters() {
        String word = "banana";
        String guessedLetters = "ban";
        String expectedDisplay = "banana";
        String actualDisplay = Main.displayWord(word, guessedLetters);
        assertEquals(expectedDisplay, actualDisplay);
    }

    @Test
    public void testDisplayWordWithNoGuessedLetters() {
        String word = "cherry";
        String guessedLetters = "";
        String expectedDisplay = "______";
        String actualDisplay = Main.displayWord(word, guessedLetters);
        assertEquals(expectedDisplay, actualDisplay);
    }

    @Test
    public void testIsValidGuess() {
        String validGuess = "a";
        String invalidGuess = "12";
        assertTrue(Main.isValidGuess(validGuess));
        assertFalse(Main.isValidGuess(invalidGuess));
    }

    @Test
    public void testDisplayWordWithPartialGuessedLetters() {
        String word = "kiwi";
        String guessedLetters = "ki";
        String expectedDisplay = "ki_i";
        String actualDisplay = Main.displayWord(word, guessedLetters);
        assertEquals(expectedDisplay, actualDisplay);
    }
}
