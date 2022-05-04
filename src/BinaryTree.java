public class BinaryTree {
    public Node root;

    public BinaryTree(){
        this.root = null;
    }
    public BinaryTree(int root){
        this.root = new Node(root);
    }
    /**
     * Inserts new node at the furthest left of given node
     * @param current
     * @param previous
     * @param value
     */
    public void deepInsertLeft(Node current, Node previous, int value){
        if (current != null){
            deepInsertLeft(current.left, current, value);
        }
        else{
            previous.left = new Node(value);
        }
    }

    /**
     * Inserts new node at the furthest right of given node
     * @param current
     * @param previous
     * @param value
     */
    public void deepInsertRight(Node current, Node previous, int value){
        if (current != null){
            deepInsertRight(current.right, current, value);
        }
        else{
            previous.right = new Node(value);
        }
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
