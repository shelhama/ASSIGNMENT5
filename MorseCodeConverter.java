import java.io.*;
import java.util.*;

/**
 * A utility class that converts Morse code into English using a MorseCodeTree.
 * This class contains static methods for converting a Morse code string or a file
 * containing Morse code into readable English text.
 * 
 * It also includes a method to print the contents of the tree in LNR (in-order) format.
 * 
 * @author Samuella Helha
 */
public class MorseCodeConverter {

    /** A static instance of the MorseCodeTree used for conversions. */
    private static MorseCodeTree morseTree = new MorseCodeTree();

    /**
     * Converts a given Morse code string into English.
     * Each letter is separated by a space, and words are separated by a slash (/).
     * 
     * @param code the Morse code string to convert (e.g., ".... . .-.. .-.. --- / .-- --- .-. .-.. -..")
     * @return the English translation of the Morse code (e.g., "hello world")
     */
    public static String convertToEnglish(String code) {
        StringBuilder result = new StringBuilder();
        String[] words = code.trim().split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                result.append(morseTree.fetch(letter));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    /**
     * Converts the contents of a file containing Morse code into English.
     * Each line in the file is appended together and then passed to convertToEnglish(String).
     * 
     * @param file the file containing Morse code
     * @return the English translation of the Morse code in the file
     * @throws FileNotFoundException if the file cannot be found or opened
     */
    public static String convertToEnglish(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder morse = new StringBuilder();
        while (scanner.hasNextLine()) {
            morse.append(scanner.nextLine()).append(" ");
        }
        scanner.close();
        return convertToEnglish(morse.toString());
    }

    /**
     * Returns the in-order traversal of the Morse code tree as a space-separated string.
     * This method is useful for testing the structure of the Morse code tree.
     * 
     * @return a string representing the tree in in-order format (LNR traversal)
     */
    public static String printTree() {
        ArrayList<String> list = morseTree.toArrayList();
        return String.join(" ", list);
    }
}
