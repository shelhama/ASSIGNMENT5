import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * A student-written JUnit test class for the MorseCodeTree class.
 * This class tests key functionalities of the MorseCodeTree including:
 * fetching letters from Morse code, inserting new nodes, and in-order traversal.
 * 
 * @author Samuella helha
 */
public class MorseCodeTreeStudentTest {

    /** Instance of MorseCodeTree to be used in each test case */
    private MorseCodeTree tree;

    /**
     * Sets up a fresh MorseCodeTree before each test case.
     * Ensures each test starts with a clean and correctly built tree.
     */
    @Before
    public void setUp() {
        tree = new MorseCodeTree();
    }

    /**
     * Tests fetching of known letters based on valid Morse code inputs.
     * Verifies that the correct English characters are returned from the tree.
     */
    @Test
    public void testFetchKnownLetters() {
        assertEquals("s", tree.fetch("..."));
        assertEquals("o", tree.fetch("---"));
        assertEquals("g", tree.fetch("--."));
        assertEquals("a", tree.fetch(".-"));
        assertEquals("q", tree.fetch("--.-"));
    }

    /**
     * Tests that the in-order (LNR) traversal of the MorseCodeTree
     * returns the expected sequence of letters.
     * This confirms that the tree structure matches the Morse code standard.
     */
    @Test
    public void testInOrderTraversal() {
        ArrayList<String> traversal = tree.toArrayList();
        String result = String.join(" ", traversal);

        // Expected LNR traversal result based on Morse tree structure
        String expected = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
        assertEquals(expected, result);
    }

    /**
     * Tests that fetch returns null for an invalid Morse code input.
     * Also tests that an empty string fetches the root (which is an empty string).
     */
    @Test
    public void testFetchInvalidCode() {
        assertNull(tree.fetch("----"));         // Invalid Morse code
        assertEquals("", tree.fetch(""));       // Root returns an empty string
    }

    /**
     * Tests that a new custom node can be inserted into the Morse code tree
     * and then successfully fetched based on its Morse code path.
     */
    @Test
    public void testInsertCustomNode() {
        tree.insert("..--", "@");               // Non-standard Morse insertion
        assertEquals("@", tree.fetch("..--"));  // Should return the custom letter
    }
}
