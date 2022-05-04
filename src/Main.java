public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(5);
        Node rootNode = binaryTree.root;
        binaryTree.deepInsertLeft(rootNode, rootNode, 3);
        binaryTree.deepInsertLeft(rootNode, rootNode, 3);
        binaryTree.deepInsertLeft(rootNode, rootNode, 2);

        binaryTree.print("", binaryTree.root);
    }
}