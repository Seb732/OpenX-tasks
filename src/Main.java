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
        System.out.println("Number of nodes that do not have any children: " + binaryTree.getIncompleteNodes(rootNode));
        //----------------------------------------------------------------------------------

        // Task 1 - point 2 ----------------------------------------------------------------
        System.out.println("Largest number of edges in path from root node a leaf node: " + (binaryTree.longestPath(rootNode).size() - 1));
        System.out.println("Path: " + binaryTree.getLongestPath());
        //System.out.println();
        //----------------------------------------------------------------------------------

        // Task 1 - point 3 ----------------------------------------------------------------
        /*BinaryTree binaryTree2 = new BinaryTree(5);
        Node rootNode2 = binaryTree2.root;
        rootNode2.insertRight(7);
        rootNode2.right.insertRight(0);
        rootNode2.right.right.insertRight(8);
        rootNode2.right.right.insertLeft(2);
        rootNode2.right.right.right.insertRight(5);
        rootNode2.right.insertLeft(1);
        rootNode2.insertLeft(3);
        rootNode2.left.insertLeft(2);
        rootNode2.left.insertRight(5);*/
        //System.out.println(BinaryTree.compareTrees(binaryTree.root, binaryTree2.root));
        //----------------------------------------------------------------------------------

        // tree
        System.out.println("Tree overview: ");
        binaryTree.print("", binaryTree.root);
    }
}