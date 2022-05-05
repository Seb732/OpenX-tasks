import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTree {
    public Node root;
    private int incompleteNodeNumber = 0;

    /**
     * Default constructor - sets root as null
     */
    public BinaryTree(){
        this.root = null;
    }

    /**
     * Binary tree constructor
     * @param value - value of root node
     */
    public BinaryTree(int value){
        this.root = new Node(value);
    }

    /**
     * This method returns whole number of nodes
     * @param current
     * @return
     */
    public int getNodeNumber(Node current){
        // base case - no more nodes
        if (current == null){
            return 0;
        }
        // add one for current node and traverse its left and right edge
        return 1 + getNodeNumber(current.left) + getNodeNumber(current.right);
    }

    /**
     * Returns the number of nodes which doesn't have any children
     * @param current - current node
     * @return - number of incomplete nodes
     */
    public int getIncompleteNodes(Node current){

        // base case - end of current traversal
        if (current == null){
           return 0;
        }

        // count for node which doesn't have any children
        if (current.left == null && current.right == null){
           this.incompleteNodeNumber++;
        }
        // recursively traverse the left and right subtree
        getIncompleteNodes(current.left);
        getIncompleteNodes(current.right);

        return this.incompleteNodeNumber;
    }

    /**
     * Method which finds the path from root node to a leaf node. It recursively traverses the left and right subtrees.
     * In each recursion get the longer path from left and right node children. In result, we get the longest path.
     * @param current - default parameter must be the root node
     * @return - list of nodes integer data from the longest path
     */
    public List<Integer> longestPath(Node current){

        // if current node is null - return empty list
        if (current == null){
            return new ArrayList<>();
        }
        // Recursively traverse the tree and create list for every node
        List<Integer> left = longestPath(current.left);
        List<Integer> right = longestPath(current.right);

        // Check for longest path in current recursion
        if (right.size() < left.size())
        {
            left.add(current.data);
        }
        else
        {
            right.add(current.data);
        }

        // return the longer path from left and right subtrees
        if (left.size() > right.size()){
            return left;
        }
        return right;
    }

    /**
     * Utility method for printing the longest path in tree
     * @return - String with nodes of the longest path
     */
    public String getLongestPath(){
        // get the longest path
        List<Integer> longestPath = longestPath(this.root);
        // reverse order list
        Collections.reverse(longestPath);
        // convert element type to string and join with delimiter
        return longestPath.stream().map(Object::toString).collect(Collectors.joining(" -> "));
    }
    /**
     * Method which prints recursively tree in horizontal way
     * @param prefix
     * @param node
     *
     */
    public void print(String prefix, Node node) {
        if (node != null) {
            // Insert a new level of depth as multi-space
            print(prefix + "     ", node.right);
            System.out.println (prefix + ("|-- ") + node.data);
            // Insert a new level of depth as multi-space
            print(prefix + "     ", node.left);
        }
    }
}
