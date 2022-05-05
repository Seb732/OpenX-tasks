import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class NodeTest {
    @Test
    @DisplayName("Ensure that new node was added to the left edge of given node")
    public void testInsertionNodeLeft(){
        Node node = new Node(5);
        node.insertLeft(8);
        Assertions.assertEquals(8, node.left.data);
    }
    @Test
    @DisplayName("Ensure that new node was added to the right edge of given node")
    public void testInsertionNodeRight(){
        Node node = new Node(2);
        node.insertRight(10);
        Assertions.assertEquals(10, node.right.data);
    }

}