package org.example;

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final String[] wordList = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "orange", "pear", "quince", "strawberry", "watermelon", "avocado", "blueberry", "cantaloupe", "pineapple", "broccoli", "carrot", "cucumber", "eggplant", "lettuce", "pepper", "potato", "tomato", "zucchini"};

    private static final Random random = new Random();

    public static void main(String[] args) {
        String wordToGuess = chooseWord().toLowerCase();
        StringBuilder guessedLetters = new StringBuilder();
        int attempts = 6;

        System.out.println("Welcome to Hangman!");

        while (attempts > 0) {
            System.out.println("\nWord: " + displayWord(wordToGuess, guessedLetters.toString()));
            System.out.println("Attempts left: " + attempts);

            System.out.print("Guess a letter: ");
            Scanner scanner = new Scanner(System.in);
            String guess = scanner.next().toLowerCase();

            if (!isValidGuess(guess)) {
                System.out.println("Please enter a valid English letter.");
                continue;
            }

            if (guessedLetters.toString().contains(guess)) {
                System.out.println("You've already guessed that letter.");
                continue;
            }

            guessedLetters.append(guess);

            if (displayWord(wordToGuess, guessedLetters.toString()).equals(wordToGuess)) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                break;
            } else if (wordToGuess.contains(guess)) {
                System.out.println("Good guess!");
            } else {
                System.out.println("Wrong guess!");
                attempts--;
            }
        }

        if (attempts == 0) {
            System.out.println("You're out of attempts! The word was: " + wordToGuess);
        }
    }

    private static String chooseWord() {
        return wordList[random.nextInt(wordList.length)];
    }

    static String displayWord(String word, String guessedLetters) {
        StringBuilder display = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(String.valueOf(letter))) {
                display.append(letter);
            } else {
                display.append("_");
            }
        }
        return display.toString();
    }

    static boolean isValidGuess(String guess) {
        return guess.matches("[a-zA-Z]") && guess.length() == 1;
    }
}
