package datastructures;

import datastructures.concrete.BST;
import datastructures.concrete.BST.Node;
import misc.BaseTest;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestAvlTree extends BaseTest {

    @Test(timeout = SECOND)
    public void testValidAVLTreeBasic() {
        // Creates a Binary Search Tree using the given values provided in insertion order.
        BST tree = new BST(new int[]{2, 1, 3});
        // Set the expected value to true if the your BST is a valid AVL tree, otherwise set it to false.
        assertEquals(true, tree.isValidAVL());
    }

    @Test(timeout = SECOND)
    public void testInvalidAVLTreeBasic() {
        // Creates a Binary Search Tree with the given values provided in insertion order.
        BST tree = new BST(new int[]{1, 2, 3});
        tree.insert(4);  // You can also add nodes to your BST using insert.
        // Set the expected value to true if the your BST is a valid AVL tree, otherwise set it to false.
        assertEquals(false, tree.isValidAVL());
    }

    // Write more black box tests to test cases for an implementation of isValidAVL method.
    @Test(timeout = SECOND)
    public void testValidAVLTreeHappyPositive() {
        // Creates a Binary Search Tree with the given values provided in insertion order.
        BST tree = new BST(new int[]{6, 3, 7, 8, 2, 4});

        // helper methods to print/see your BST
        //tree.printInorder();
        //tree.printSideways();

        // Set the expected value to true if the your BST is a valid AVL tree, otherwise set it to false.
        assertEquals(true, tree.isValidAVL());

    }

    @Test(timeout = SECOND)
    public void testValidAVLTreeHappyNegative() {
        BST tree = new BST(new int[]{2, 3, 4, 6, 7, 8});
        // Set the expected value to true if the your BST is a valid AVL tree, otherwise set it to false.
        assertEquals(false, tree.isValidAVL());        
    }

    @Test(timeout = SECOND)
    public void testValidAVLTreeSpecial() {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);

        //tree.printSideways();
        //tree.printSideways();
        for (int i = 0; i < 10000; i++) {
            assertEquals(true, tree.isValidAVL());  
        }
    }

    @Test(timeout = SECOND)
    public void testValidAVLTreeExceptionPositive() {
        BST tree = new BST();
        assertEquals(true, tree.isValidAVL());
        tree.insert(2);
        tree.insert(2);
        tree.insert(2);
        tree.insert(2);
        assertEquals(true, tree.isValidAVL());        
    }

    @Test(timeout = SECOND)
    public void testValidAVLTreeEmptyPositive() {
        BST tree = new BST();
        assertEquals(true, tree.isValidAVL());   
        tree.insert(2); 
        assertEquals(true, tree.isValidAVL());
        tree.insert(3); 
        assertEquals(true, tree.isValidAVL());
        tree.insert(4);
        assertEquals(false, tree.isValidAVL());
        tree.reset();   
        assertEquals(true, tree.isValidAVL());   
    }

    @Test(timeout = SECOND)
    public void testValidAVLTreeEdgePositive() {
        BST tree = new BST();
        assertEquals(true, tree.isValidAVL());
        tree.insert(2);
        assertEquals(true, tree.isValidAVL());
        tree.insert(3);
        assertEquals(true, tree.isValidAVL());
        tree.insert(1);
        assertEquals(true, tree.isValidAVL());
        tree.insert(4);
        assertEquals(true, tree.isValidAVL());
    }

    @Test(timeout = SECOND)
    public void testValidAVLTreeEdgeNegative() {
        BST tree = new BST();
        assertEquals(true, tree.isValidAVL());
        tree.insert(2);
        assertEquals(true, tree.isValidAVL());
        tree.insert(3);
        assertEquals(true, tree.isValidAVL());
        tree.insert(4);
        assertEquals(false, tree.isValidAVL());
        tree.insert(5);
        assertEquals(false, tree.isValidAVL());
        tree.insert(1);
        assertEquals(false, tree.isValidAVL());
    }

    @Test(timeout = SECOND)
    public void testValidAVLTreeEfficiency() {
        BST tree = new BST();
        int cap = 5000;
        for (int i = 0; i < cap; i++) {
            tree.insert(i);
        }
        assertEquals(false, tree.isValidAVL());
    }
  
    @Test(timeout = SECOND)
    public void testValidAVLTreeCase1() {
        BST tree = new BST();
        assertEquals(true, tree.isValidAVL());
        tree.insert(2);
        assertEquals(true, tree.isValidAVL());
        tree.insert(1);
        assertEquals(true, tree.isValidAVL());
        tree.insert(5);
        assertEquals(true, tree.isValidAVL());
        tree.insert(6);
        assertEquals(true, tree.isValidAVL());
        tree.insert(3);
        assertEquals(true, tree.isValidAVL());
        tree.insert(4);
        assertEquals(false, tree.isValidAVL());        
    }
    
    @Test(timeout = SECOND)
    public void testValidAVLTreeCase2() {
        BST tree = new BST();
        assertEquals(true, tree.isValidAVL());
        tree.insert(2);
        assertEquals(true, tree.isValidAVL());
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        assertEquals(true, tree.isValidAVL());
        tree.getRoot().right.left.data = 1;
        assertEquals(false, tree.isValidAVL());        
    }
    
    @Test(timeout = SECOND)
    public void testValidAVLTreeCase3() {
        BST tree = new BST();
        assertEquals(true, tree.isValidAVL());
        tree.insert(3);
        assertEquals(true, tree.isValidAVL());
        tree.insert(2);
        assertEquals(true, tree.isValidAVL());
        tree.insert(4);
        assertEquals(true, tree.isValidAVL());
        tree.insert(1);
        assertEquals(true, tree.isValidAVL());
        tree.insert(5);
        assertEquals(true, tree.isValidAVL());
        tree.insert(0);
        assertEquals(false, tree.isValidAVL());        
    }
    
    @Test(timeout = SECOND)
    public void testValidAVLTreeCase4() {
        BST tree = new BST();
        assertEquals(true, tree.isValidAVL());
        tree.insert(2);
        assertEquals(true, tree.isValidAVL());
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        assertEquals(true, tree.isValidAVL());
        tree.insert(3);
        assertEquals(false, tree.isValidAVL());
        tree.insert(-1);
        assertEquals(false, tree.isValidAVL());
        tree.insert(6);
        assertEquals(true, tree.isValidAVL());
    } 
    
    @Test(timeout = 60 * SECOND)
    public void testValidAVLTreeCase5() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 15; i++) {
            list.add(i);
        }
        loop(list, new Stack<Integer>());
    } 
    
    private void loop(List<Integer> list, Stack<Integer> s) {
        if (list.isEmpty()) {
            BST tree = new BST();
            Stack<Integer> temp = new Stack<Integer>();
            while (!s.empty()) {
                tree.insert(s.peek());
                temp.push(s.pop());
                assertEquals(traverseCheck(tree.getRoot()), tree.isValidAVL());
            }
            while (!temp.empty()) {
                s.push(temp.pop());
            }
        } else {
            for (int j = 0; j < list.size(); j++) {
                s.push(list.remove(j));
                loop(list, s);
                list.add(j, s.pop());
            }
        }
    }
    
    private boolean traverseCheck(Node root) {
        if (root == null) {
            return true;
        } else if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        } 
        return traverseCheck(root.left) && traverseCheck(root.right);
    }
    

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
    /*
     * Instructions:
     *
     * We will be running all the tests in this file against 11 different implementations of isValidAVL() method
     * (These implementations are not accessible to you.)
     * One of these implementations is a correct implementation, and the other 10 are buggy implementations.
     *
     * You task is to write black box tests to for an isValidAVL method.
     * Recall from class: a black box test is when you do not know the implementation, but you know the expected
     * behavior.
     *
     *
     *
     * You get points for correctly predicting whether an isValidAVL method implementation is buggy or correct.
     * There are 11 implementations (one correct, 10 buggy), each worth 1 point. If you correctly identify all 11,
     * you get 11 points.
     * But if you fail to identify the correct implementation, you don't get any points at all (you get zero points).
     *
     * When we run all your tests against an implementation,
     *    - if all your tests pass, that means as per your tests the implementation is correct, but
     *    - if even one of your test fails, that means as per your tests the implementation is buggy.
     *
     *
     * For details on how we will test and score your tests, see the course website.
     *
     */

}
