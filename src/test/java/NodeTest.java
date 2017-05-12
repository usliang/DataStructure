import org.junit.Assert;
import org.junit.Test;

/**
 * Created by liliang on 5/4/17.
 *
 */
public class NodeTest {

    @Test
    public void testIsBalance(){

        BinaryTree.Node root = buildBalanceTree();
        Assert.assertTrue(BinaryTree.isBalance(root));

        root = buildUnBalanceTree();
        Assert.assertFalse(BinaryTree.isBalance(root));
    }

    public BinaryTree.Node buildBalanceTree() {


        BinaryTree.Node root = new BinaryTree.Node();
        root.data = 1;

        BinaryTree.Node left = new BinaryTree.Node();
        left.data = 2;

        BinaryTree.Node right = new BinaryTree.Node();
        right.data = 3;

        root.left = left;
        root.right = right;

        BinaryTree.Node leaf1 = new BinaryTree.Node();
        leaf1.data = 4;
        leaf1.left = null;
        leaf1.right = null;

        BinaryTree.Node leaf2 = new BinaryTree.Node();
        leaf2.data = 5;
        leaf2.left = null;
        leaf2.right = null;

        left.left = leaf1;
        left.right = leaf2;

        BinaryTree.Node leaf3 = new BinaryTree.Node();
        leaf3.data = 6;
        leaf3.left = null;
        leaf3.right = null;

        BinaryTree.Node leaf4 = new BinaryTree.Node();
        leaf4.data = 7;
        leaf4.left = null;
        leaf4.right = null;

        right.left = leaf3;
        right.right = leaf4;

        return root;
    }

    public BinaryTree.Node buildUnBalanceTree() {


        BinaryTree.Node root = new BinaryTree.Node();
        root.data = 1;

        BinaryTree.Node left = new BinaryTree.Node();
        left.data = 2;

        BinaryTree.Node right = new BinaryTree.Node();
        right.data = 3;

        root.left = left;
        root.right = right;

        BinaryTree.Node leaf1 = new BinaryTree.Node();
        leaf1.data = 4;
        leaf1.left = null;
        leaf1.right = null;

        BinaryTree.Node leaf2 = new BinaryTree.Node();
        leaf2.data = 5;
        leaf2.left = null;
        leaf2.right = null;

        left.left = leaf1;
        left.right = leaf2;

        BinaryTree.Node leaf3 = new BinaryTree.Node();
        leaf3.data = 6;
        leaf3.left = null;
        leaf3.right = null;

        BinaryTree.Node leaf4 = new BinaryTree.Node();
        leaf4.data = 7;
        leaf4.left = null;
        leaf4.right = null;

        right.left = leaf3;
        right.right = null;

        return root;
    }

    public BinaryTree.Node buildTreeWithParentLink() {


        BinaryTree.Node root = new BinaryTree.Node();
        root.data = 1;

        BinaryTree.Node left = new BinaryTree.Node();
        left.data = 2;

        BinaryTree.Node right = new BinaryTree.Node();
        right.data = 3;

        root.left = left;
        root.right = right;
        root.parent = null;

        BinaryTree.Node leaf1 = new BinaryTree.Node();
        leaf1.data = 4;
        leaf1.left = null;
        leaf1.right = null;
        leaf1.parent = left;

        BinaryTree.Node leaf2 = new BinaryTree.Node();
        leaf2.data = 5;
        leaf2.left = null;
        leaf2.right = null;
        leaf2.parent = left;

        left.left = leaf1;
        left.right = leaf2;
        left.parent =root;

        BinaryTree.Node leaf3 = new BinaryTree.Node();
        leaf3.data = 6;
        leaf3.left = null;
        leaf3.right = null;
        leaf3.parent = right;

        BinaryTree.Node leaf4 = new BinaryTree.Node();
        leaf4.data = 7;
        leaf4.left = null;
        leaf4.right = null;
        leaf4.parent = right;

        right.left = leaf3;
        right.right = leaf4;
        right.parent = right;

        return root;
    }

    @Test
    public void testFindAncestor(){
        BinaryTree.Node root = new BinaryTree.Node();
        root.data = 1;

        BinaryTree.Node left = new BinaryTree.Node();
        left.data = 2;

        BinaryTree.Node right = new BinaryTree.Node();
        right.data = 3;

        root.left = left;
        root.right = right;
        root.parent = null;

        BinaryTree.Node leaf1 = new BinaryTree.Node();
        leaf1.data = 4;
        leaf1.left = null;
        leaf1.right = null;
        leaf1.parent = left;

        BinaryTree.Node leaf2 = new BinaryTree.Node();
        leaf2.data = 5;
        leaf2.left = null;
        leaf2.right = null;
        leaf2.parent = left;

        left.left = leaf1;
        left.right = leaf2;
        left.parent =root;

        BinaryTree.Node leaf3 = new BinaryTree.Node();
        leaf3.data = 6;
        leaf3.left = null;
        leaf3.right = null;
        leaf3.parent = right;

        BinaryTree.Node leaf4 = new BinaryTree.Node();
        leaf4.data = 7;
        leaf4.left = null;
        leaf4.right = null;
        leaf4.parent = right;

        right.left = leaf3;
        right.right = leaf4;
        right.parent = root;

        BinaryTree.Node commonAncestor = BinaryTree.findCommonAncestor(leaf1, leaf2);
        Assert.assertTrue(left==commonAncestor);

       commonAncestor = BinaryTree.findCommonAncestor(root, leaf1, leaf2);
        Assert.assertTrue(left==commonAncestor);


        commonAncestor = BinaryTree.findCommonAncestor(root, leaf2);
        Assert.assertTrue(root==commonAncestor);

        commonAncestor = BinaryTree.findCommonAncestor(root, root, leaf2);
        Assert.assertTrue(root==commonAncestor);

        commonAncestor = BinaryTree.findCommonAncestor(leaf3, leaf2);
        Assert.assertTrue(root==commonAncestor);

        commonAncestor = BinaryTree.findCommonAncestor(root, leaf3, leaf2);
        Assert.assertTrue(root==commonAncestor);

    }

    @Test
    public void testIsChild(){

        BinaryTree.Node root = new BinaryTree.Node();
        root.data = 1;

        BinaryTree.Node left = new BinaryTree.Node();
        left.data = 2;

        BinaryTree.Node right = new BinaryTree.Node();
        right.data = 3;

        root.left = left;
        root.right = right;
        root.parent = null;

        BinaryTree.Node leaf1 = new BinaryTree.Node();
        leaf1.data = 4;
        leaf1.left = null;
        leaf1.right = null;
        leaf1.parent = left;

        BinaryTree.Node leaf2 = new BinaryTree.Node();
        leaf2.data = 5;
        leaf2.left = null;
        leaf2.right = null;
        leaf2.parent = left;

        left.left = leaf1;
        left.right = leaf2;
        left.parent =root;

        BinaryTree.Node leaf3 = new BinaryTree.Node();
        leaf3.data = 6;
        leaf3.left = null;
        leaf3.right = null;
        leaf3.parent = right;

        BinaryTree.Node leaf4 = new BinaryTree.Node();
        leaf4.data = 7;
        leaf4.left = null;
        leaf4.right = null;
        leaf4.parent = right;

        right.left = leaf3;
        right.right = leaf4;
        right.parent = root;

        Assert.assertTrue(BinaryTree.isChild(root, root));

        Assert.assertFalse(BinaryTree.isChild(null, root));

        Assert.assertTrue(BinaryTree.isChild(root, left));

        Assert.assertTrue(BinaryTree.isChild(root, leaf1));

        Assert.assertTrue(BinaryTree.isChild(root, leaf3));

        Assert.assertFalse(BinaryTree.isChild(left, leaf3));

    }

}