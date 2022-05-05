public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(5);
        Node rootNode = binaryTree.root;
        rootNode.insertRight(7);
        rootNode.right.insertRight(0);
        rootNode.right.right.insertRight(8);
        rootNode.right.right.insertLeft(2);
        rootNode.right.right.right.insertRight(5);
        rootNode.right.insertLeft(1);
        rootNode.insertLeft(3);
        rootNode.left.insertLeft(2);
        rootNode.left.insertRight(5);

        // Task 1 - point 1 ----------------------------------------------------------------
        //System.out.println(binaryTree.getIncompleteNodes(rootNode));
        //----------------------------------------------------------------------------------

        // Task 1 - point 2 ----------------------------------------------------------------
        System.out.println(binaryTree.getLongestPath());
        //----------------------------------------------------------------------------------

        binaryTree.print("", binaryTree.root);
    }
}