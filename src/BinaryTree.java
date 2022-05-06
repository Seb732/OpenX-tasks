import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
     * Returns the number of nodes which doesn't have any children
     * @param node - current node
     * @return - number of incomplete nodes
     */
    public int getIncompleteNodes(Node node){

        // base case - end of current traversal
        if (Objects.isNull(node)){
           return 0;
        }

        // count for node which doesn't have any children
        if (Objects.isNull(node.left) && Objects.isNull(node.right)){
           this.incompleteNodeNumber++;
        }
        // recursively traverse the left and right subtree
        getIncompleteNodes(node.left);
        getIncompleteNodes(node.right);

        return this.incompleteNodeNumber;
    }

    /**
     * Method which finds the path from root node to a leaf node. It recursively traverses the left and right subtrees.
     * In each recursion get the longer path from left and right node children. In result, we get the longest path.
     * @param node - default parameter must be the root node
     * @return - list of nodes integer data from the longest path
     */
    public List<Integer> longestPath(Node node){

        // if current node is null - return empty list
        if (Objects.isNull(node)){
            return new ArrayList<>();
        }
        // Recursively traverse the tree and create list for every node
        List<Integer> left = longestPath(node.left);
        List<Integer> right = longestPath(node.right);

        // Check for longest path in current recursion
        if (right.size() < left.size())
        {
            left.add(node.data);
        }
        else
        {
            right.add(node.data);
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
    public static boolean compareTrees(Node first, Node second){

        // Check for the leaf node
        if (Objects.isNull(first) && Objects.isNull(second)){
            return true;
        }

        if (!Objects.isNull(first) && !Objects.isNull(second)){
            // Check if nodes have the same value
            if (Objects.equals(first.data, second.data)){
                // recursively compare children nodes for each node in trees
                return compareTrees(first.left, second.left) && compareTrees(first.right, second.right);
            }
        }
        return false;
    }
    /**
     * Method which prints recursively tree in horizontal way
     * @param prefix
     * @param node
     *
     */
    public void print(String prefix, Node node) {
        if (!Objects.isNull(node)) {
            // Insert a new level of depth as multi-space
            print(prefix + "     ", node.right);
            System.out.println (prefix + ("|-- ") + node.data);
            // Insert a new level of depth as multi-space
            print(prefix + "     ", node.left);
        }
    }
}
