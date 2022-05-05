public class Node {
    Node left, right;
    int data;

    /**
     * Node constructor with two fields as a pair of its children - left and right and integer data.
     * @param data
     */
    public Node(int data){
        this.left = this.right = null;
        this.data = data;
    }
    public void insertLeft(int value){
        this.left = new Node(value);
    }
    public void insertRight(int value){
        this.right = new Node(value);
    }
}
