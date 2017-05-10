import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by liliang on 5/4/17.
 * CopyRight Apple Inc.
 */
public class NodeTest {

    @Test
    public void testIsBalance(){

        BalanceTree.Node root = buildBalanceTree();
        Assert.assertTrue(BalanceTree.isBalance(root));

        root = buildUnBalanceTree();
        Assert.assertFalse(BalanceTree.isBalance(root));
    }

    public BalanceTree.Node buildBalanceTree() {


        BalanceTree.Node root = new BalanceTree.Node();
        root.data = 1;

        BalanceTree.Node left = new BalanceTree.Node();
        left.data = 2;

        BalanceTree.Node right = new BalanceTree.Node();
        right.data = 3;

        root.left = left;
        root.right = right;

        BalanceTree.Node leaf1 = new BalanceTree.Node();
        leaf1.data = 4;
        leaf1.left = null;
        leaf1.right = null;

        BalanceTree.Node leaf2 = new BalanceTree.Node();
        leaf2.data = 5;
        leaf2.left = null;
        leaf2.right = null;

        left.left = leaf1;
        left.right = leaf2;

        BalanceTree.Node leaf3 = new BalanceTree.Node();
        leaf3.data = 6;
        leaf3.left = null;
        leaf3.right = null;

        BalanceTree.Node leaf4 = new BalanceTree.Node();
        leaf4.data = 7;
        leaf4.left = null;
        leaf4.right = null;

        right.left = leaf3;
        right.right = leaf4;

        return root;
    }

    public BalanceTree.Node buildUnBalanceTree() {


        BalanceTree.Node root = new BalanceTree.Node();
        root.data = 1;

        BalanceTree.Node left = new BalanceTree.Node();
        left.data = 2;

        BalanceTree.Node right = new BalanceTree.Node();
        right.data = 3;

        root.left = left;
        root.right = right;

        BalanceTree.Node leaf1 = new BalanceTree.Node();
        leaf1.data = 4;
        leaf1.left = null;
        leaf1.right = null;

        BalanceTree.Node leaf2 = new BalanceTree.Node();
        leaf2.data = 5;
        leaf2.left = null;
        leaf2.right = null;

        left.left = leaf1;
        left.right = leaf2;

        BalanceTree.Node leaf3 = new BalanceTree.Node();
        leaf3.data = 6;
        leaf3.left = null;
        leaf3.right = null;

        BalanceTree.Node leaf4 = new BalanceTree.Node();
        leaf4.data = 7;
        leaf4.left = null;
        leaf4.right = null;

        right.left = leaf3;
        right.right = null;

        return root;
    }
}