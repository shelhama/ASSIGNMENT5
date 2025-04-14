/**
 * A generic TreeNode class used to represent nodes in a binary tree structure.
 * Each node stores a data element and has references to its left and right child nodes.
 * This class is used by the MorseCodeTree to build a tree representation of Morse code.
 * 
 * @param <T> the type of data stored in the node
 * 
 * @author Samuella Helha 
 */
public class TreeNode<T> {

    /** The data stored in this node */
    protected T data;

    /** Reference to the left child of this node */
    protected TreeNode<T> left;

    /** Reference to the right child of this node */
    protected TreeNode<T> right;

    /**
     * Constructs a TreeNode with specified data and null left/right children.
     * 
     * @param dataNode the data to be stored in the node
     */
    public TreeNode(T dataNode) {
        this.data = dataNode;
        this.left = null;
        this.right = null;
    }

    /**
     * Constructs a new TreeNode by copying the data and children references
     * from an existing TreeNode.
     * 
     * @param node the TreeNode to copy
     */
    public TreeNode(TreeNode<T> node) {
        this.data = node.data;
        this.left = node.left;
        this.right = node.right;
    }
}
