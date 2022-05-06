import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class BinaryTreeTest {
    BinaryTree binaryTree;

    @BeforeEach
    public void setUpTree(){
        // Sample tree creation
        binaryTree = new BinaryTree(5);
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
    }

    @Test
    @DisplayName("Ensure that tree root has been created properly")
    public void testRoot(){
        Assertions.assertEquals(5, binaryTree.root.data);
    }

    @Test
    @DisplayName("Check the number of nodes who do not have any children")
    public void testIncompleteNodes(){
        Assertions.assertEquals(5, binaryTree.getIncompleteNodes(binaryTree.root));
    }

    @Test
    @DisplayName("Ensure correct finding the longest path in tree")
    public void testLongestPath(){
        List<Integer> longestPath = new ArrayList<>(Arrays.asList(5,7,0,8,5));
        List<Integer> path = binaryTree.longestPath(binaryTree.root);
        Collections.reverse(path);
        Assertions.assertEquals(longestPath, path);
    }

    @Test
    @DisplayName("Ensure correct tree comparison")
    public void testTreeComparison(){
        BinaryTree binaryTree1 = new BinaryTree(5);
        Node rootNode1 = binaryTree1.root;
        rootNode1.insertRight(7);
        rootNode1.right.insertRight(0);
        rootNode1.right.right.insertRight(8);
        rootNode1.right.right.insertLeft(2);
        rootNode1.right.right.right.insertRight(5);
        rootNode1.right.insertLeft(1);
        rootNode1.insertLeft(3);
        rootNode1.left.insertLeft(2);
        rootNode1.left.insertRight(5);

        // case when both trees are equal
        Assertions.assertTrue(BinaryTree.compareTrees(binaryTree.root, binaryTree1.root));

        // case with change in value of node in second tree
        rootNode1.left.insertRight(19);
        Assertions.assertFalse(BinaryTree.compareTrees(binaryTree.root, binaryTree1.root));

        // case with empty trees
        BinaryTree binaryTree2 = new BinaryTree();
        BinaryTree binaryTree3 = new BinaryTree();

        Assertions.assertTrue(BinaryTree.compareTrees(binaryTree2.root, binaryTree3.root));

        // case with different node children
        rootNode1.left.insertLeft(5);
        rootNode1.left.right.insertRight(9);
        Assertions.assertFalse(BinaryTree.compareTrees(binaryTree.root, binaryTree1.root));

    }
}