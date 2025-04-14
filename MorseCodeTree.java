import java.util.ArrayList;

/**
 * Represents a binary tree specifically structured to convert Morse code to English.
 * Implements the LinkedConverterTreeInterface with String data.
 * Each node corresponds to a Morse code character where '.' indicates left and '-' indicates right.
 * 
 * This tree builds a 5-level Morse code structure where characters are inserted
 * based on their Morse representation.
 * 
 * @author Samuella helha
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    /** Root node of the MorseCodeTree */
    private TreeNode<String> root;

    /**
     * Constructor initializes the tree by calling buildTree().
     */
    public MorseCodeTree() {
        buildTree();
    }

    /**
     * Builds the Morse code binary tree by inserting each letter
     * at its respective Morse code position.
     */
    @Override
    public void buildTree() {
        root = new TreeNode<>("");
        insert(".", "e");
        insert("-", "t");
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    /**
     * Returns the root of the MorseCodeTree.
     * 
     * @return the root node
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * Sets the root of the MorseCodeTree.
     * 
     * @param newNode the new root node
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    /**
     * Inserts a letter into the tree based on its Morse code.
     * 
     * @param code the Morse code sequence
     * @param letter the English letter to insert
     */
    @Override
    public void insert(String code, String letter) {
        addNode(root, code, letter);
    }

    /**
     * Helper method for inserting a node based on the code path.
     * 
     * @param current the current node being evaluated
     * @param code the Morse code string
     * @param letter the letter to insert
     */
    @Override
    public void addNode(TreeNode<String> current, String code, String letter) {
        for (int i = 0; i < code.length(); i++) {
            char symbol = code.charAt(i);
            if (i == code.length() - 1) {
                if (symbol == '.') {
                    current.left = new TreeNode<>(letter);
                } else {
                    current.right = new TreeNode<>(letter);
                }
            } else {
                if (symbol == '.') {
                    if (current.left == null) current.left = new TreeNode<>("");
                    current = current.left;
                } else {
                    if (current.right == null) current.right = new TreeNode<>("");
                    current = current.right;
                }
            }
        }
    }

    /**
     * Retrieves a letter from the tree based on its Morse code.
     * 
     * @param code the Morse code
     * @return the corresponding English letter
     */
    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    /**
     * Helper method for fetching a node value based on Morse code.
     * 
     * @param current the node to start from
     * @param code the Morse code sequence
     * @return the corresponding letter or null if not found
     */
    @Override
    public String fetchNode(TreeNode<String> current, String code) {
        for (int i = 0; i < code.length(); i++) {
            if (current == null) return null;
            current = (code.charAt(i) == '.') ? current.left : current.right;
        }
        return current != null ? current.data : null;
    }

    /**
     * Returns the tree contents in an ArrayList using in-order traversal (LNR).
     * 
     * @return list of letters in in-order sequence
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    /**
     * Performs in-order traversal (LNR) of the tree and adds non-empty values to the list.
     * 
     * @param root the starting node
     * @param list the list to add node values to
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root == null) return;
        LNRoutputTraversal(root.left, list);
        if (!root.data.equals(" ")) list.add(root.data);
        LNRoutputTraversal(root.right, list);
    }

    /**
     * Delete operation is not supported for MorseCodeTree.
     * 
     * @param data the data to delete
     * @return nothing, always throws exception
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Delete operation is not supported.");
    }

    /**
     * Update operation is not supported for MorseCodeTree.
     * 
     * @return nothing, always throws exception
     * @throws UnsupportedOperationException always thrown
     */
    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Update operation is not supported.");
    }
}
