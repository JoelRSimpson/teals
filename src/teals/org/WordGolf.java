package teals.org;

import java.util.*;

public class WordGolf {

    private static boolean debugging = false;

    private static int parseWord(String word) {
        if (debugging) System.out.println("[DEBUG] parseWord: \"" + word + "\"");
        int score = 1; //The value of a word always starts at 1!
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            if (isaVowel(c)) {
                score *= 2;
                if (debugging) System.out.println("[DEBUG] " + word.charAt(i) + "(*2) = " + score);

            } else if (isaConsonant(c)) {
                score++;
                if (debugging) System.out.println("[DEBUG] " + word.charAt(i) + "(+1) = " + score);

            }
        }
        return score;
    }

    private static boolean isaVowel(char c) {
        String vowels = "aeiouyAEIOUY";
        return (vowels.indexOf(c) > -1);
    }

    private static boolean isaConsonant(char c) {
        String consonants = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
        return (consonants.indexOf(c) > -1);
    }

    /**
     * Parses the sentence for words:
     * Uses a scanner to split out the words simplifying the logic substantially
     */
    private static int parseSentence2(String sentence) {
        //look for words using a scanner created from the sentence
        Scanner sentenceScanner = new Scanner(sentence);

        int sentenceScore = 0;
        while (sentenceScanner.hasNext()) {
            String word = sentenceScanner.next();
            int score = parseWord(word);
            sentenceScore += score;
        }

        if (debugging) System.out.println("[DEBUG] Sentence Score: " + sentenceScore);
        return sentenceScore;
    }


    /**
     * Parses the sentence for words:
     * Without copying/modifying the string, by simply iterating over characters and tracking the last space.
     */
    private static int parseSentence3(String sentence) {
        int sentenceScore = 0;
        int lastSpaceIndex = 0; //use this to track the index of the last space we saw

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                String word = sentence.substring(lastSpaceIndex, i);
                sentenceScore += parseWord(word);
                lastSpaceIndex = i + 1; //now use this space as the starting point for the next word
            }
        }
        //Capture the last word in the sentence...it ends at the end of the string instead of a space
        String word = sentence.substring(lastSpaceIndex, sentence.length());
        sentenceScore += parseWord(word);

        if (debugging) System.out.println("[DEBUG] Sentence Score: " + sentenceScore);
        return sentenceScore;
    }

    /**
     * Parses the sentence for words:
     * Uses the approach indicated in the instructions. "Revise the sentence to include only the remaining words."
     */
    private static int parseSentence(String sentence) {
        int sentenceScore = 0;
        while (sentence.indexOf(" ") > -1) {
            int endOfWord = sentence.indexOf(" ");
            //extract a word
            String word = sentence.substring(0, endOfWord);
            //score the word and add it to our total sentenceScore
            sentenceScore += parseWord(word);
            //remove the word from the sentence by copying only everything following the first space we find.
            sentence = sentence.substring(endOfWord + 1);//+1 to skip the space
            if (debugging) System.out.println("[DEBUG] now: |" + sentence + "|");
        }
        sentenceScore += parseWord(sentence);

        return sentenceScore;
    }

    public static void main(String[] args) {

        int strokes = 0;
        int score = 0;
        //debugging = true;

        //REQ: creates a Scanner,
        Scanner console = new Scanner(System.in);

        while (score != 100) {

            strokes++;
            //REQ: Accepts in a sentence instead of a single word, and
            System.out.print("Enter a sentence: ");
            String sentence = console.nextLine();

            //REQ: passes that sentence as a parameter into a function called parseSentence()
            int sentenceScore = parseSentence(sentence);
            System.out.println("Stroke " + strokes + ": \"" + sentence + "\" = " + sentenceScore + " points");

            if (score > 100) {
                score -= sentenceScore;
            } else if (score < 100) {
                score += sentenceScore;
            }

            if (score == 100) {
                System.out.println("Congratulations, you won with only " + strokes + " strokes!");
            } else if (score > 100) {
                System.out.println("Your total is " + score + " points. You overshot your goal by " + (score - 100) + " pts!");
            } else if (score < 100) {
                System.out.println("Your total is " + score + " points, " + (100 - score) + " from the goal.");
            }
            System.out.println();
        }

    }
}
