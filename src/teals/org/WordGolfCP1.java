package teals.org;

import java.util.*;

/**
 * THIS SHOWS HOW THE INSTRUCTIONS CAN DIRECTLY BE USED AS PSEUDO CODE
 *
Checkpoint 1: Parsing One Word [due ___________________ ]
        ● Your main() method
        ○ creates a Scanner,
        ○ reads one word, and
        ○ passes that word as a parameter to a function called parseWord().
        ● parseWord() takes in the word, calculates the value of that word and returns it.
        ○ Remember: The value of a word always starts at 1!
        ○ Hint: You should look at each letter one at at a time to evaluate:
        ■ Multiply by 2 for each vowel
        ■ Add 1 for each consonant
        ● main() prints the result returned by parseWord().
**/

public class WordGolfCP1 {

    public static void main(String[] args) {
        //creates a Scanner
        Scanner console = new Scanner(System.in);
        //reads one word, and
        String word = console.next();
        // passes that word as a parameter to a function called parseWord().
        parseWord(word);

        //main() prints the result returned by parseWord().
        System.out.println(parseWord(word));
    }

    // parseWord() takes in the word, calculates the value of that word and returns it.
    private static int parseWord(String word) {

        // Remember: The value of a word always starts at 1!
        int value = 1;
        // Hint: You should look at each letter one at at a time to evaluate:
        for (int i = 0; i<word.length(); i++){

            if (isaVowel(word.charAt(i))){
                // Multiply by 2 for each vowel
                value = value * 2;
            }

            if (isaConsonant(word.charAt(i))) {
                // Add 1 for each consonant
                value = value + 1;
            }
        }

        // parseWord() takes in the word, calculates the value of that word and returns it.
        return value;

    }

    private static boolean isaVowel(char c) {
        String vowels = "aeiouyAEIOUY";
        return (vowels.indexOf(c) > -1);
    }

    private static boolean isaConsonant(char c) {
        String consonants = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
        return (consonants.indexOf(c) > -1);
    }


}
