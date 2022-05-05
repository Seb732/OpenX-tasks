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
     * Returns all nodes which doesn't have two children as difference between complete nodes and contrary
     * @param current - current node
     * @return - number of incomplete nodes
     */
    public int getIncompleteNodes(Node current){

        // base case - end of leaf
        if (current == null){
           return 0;
        }

        // count for node which doesn't have any children
        if (current.left == null && current.right == null){
           this.incompleteNodeNumber++;
        }
        // recursively traverse the tree
        getIncompleteNodes(current.left);
        getIncompleteNodes(current.right);

        return this.incompleteNodeNumber;
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
