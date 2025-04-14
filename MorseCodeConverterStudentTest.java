import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * A student-written JUnit test class for the MorseCodeConverter utility.
 * This class tests the conversion of Morse code to English using both
 * a direct String input and a file input.
 * 
 * @author Samuella helha
 * Date: 4/13/2025
 */
public class MorseCodeConverterStudentTest {

    /**
     * Tests the convertToEnglish(String) method by passing a Morse code string
     * and asserting that the correct English translation is returned.
     */
    @Test
    public void testConvertToEnglish_String() {
        // Arrange
        String morse = "... --- ... / - .... .. ... / .. ... / .- / - . ... -";
        
        // Act
        String result = MorseCodeConverter.convertToEnglish(morse);
        
        // Assert
        assertEquals("sos this is a test", result);
    }

    /**
     * Tests the convertToEnglish(File) method by creating a temporary file
     * containing Morse code, converting its content to English, and verifying
     * the output matches the expected English string.
     * 
     * @throws IOException if the temporary file cannot be created or read
     */
    @Test
    public void testConvertToEnglish_File() throws IOException {
        // Arrange
        File tempFile = new File("studentTest.txt");
        PrintWriter writer = new PrintWriter(tempFile);
        writer.println("- .... .. ... / .. ... / ..-. .. .-.. . / - . ... -");
        writer.close();

        // Act
        String result = MorseCodeConverter.convertToEnglish(tempFile);

        // Assert
        assertEquals("this is file test", result);

        // Clean up
        tempFile.delete();
    }
}
