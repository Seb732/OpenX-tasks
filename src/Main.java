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

        BinaryTree binaryTree2 = new BinaryTree(5);
        Node rootNode2 = binaryTree2.root;
        rootNode2.insertRight(7);
        rootNode2.right.insertRight(0);
        rootNode2.right.right.insertRight(8);
        rootNode2.right.right.insertLeft(2);
        rootNode2.right.right.right.insertRight(5);
        rootNode2.right.insertLeft(1);
        rootNode2.insertLeft(3);
        rootNode2.left.insertLeft(2);
        rootNode2.left.insertRight(5);

        // Task 1 - point 1 ----------------------------------------------------------------
        //System.out.println(binaryTree.getIncompleteNodes(rootNode));
        //----------------------------------------------------------------------------------

        // Task 1 - point 2 ----------------------------------------------------------------
        //System.out.println(binaryTree.getLongestPath());
        //----------------------------------------------------------------------------------

        // Task 1 - point 3 ----------------------------------------------------------------
        System.out.println(BinaryTree.compareTrees(binaryTree.root, binaryTree2.root));
        //----------------------------------------------------------------------------------

        //binaryTree.print("", binaryTree2.root);
    }
}