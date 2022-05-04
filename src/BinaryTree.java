public class BinaryTree {
    public Node root;
    protected int completeNodesNum = 0;

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

        // base case - when node has no children
        if (current.left == null || current.right == null){
            return 0;
        }

        // if node has two children add one
        this.completeNodesNum += 1;

        // recursively traverse current node edges
        getIncompleteNodes(current.left);
        getIncompleteNodes(current.right);

        // return difference between complete nodes and contrary
        return getNodeNumber(this.root) - this.completeNodesNum;
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
