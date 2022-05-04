public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.left.left = new Node(5);
        binaryTree.root.right = new Node(10);
        //binaryTree.traverseTree(binaryTree.root);
        binaryTree.print("", binaryTree.root);
    }
}