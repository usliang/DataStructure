/**
 * Created by liliang on 5/10/17.
 *
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * binary tree class
 */
public class BinaryTree {

    /**
     * node class on a tree
     */
    static class Node{
        int data;
        Node left;
        Node right;
        Node parent;


    }
    Node root;

    public static void preOrderPrint(Node cursor){

        if (null != cursor){
            System.out.println(cursor.data);
            preOrderPrint(cursor.left);
            preOrderPrint(cursor.right);
        }
    }

    public static void inOrderPrint(Node cursor){

        if (null != cursor){
            inOrderPrint(cursor.left);
            System.out.println(cursor.data);
            inOrderPrint(cursor.right);
        }
    }

    public static void postOrderPrint(Node cursor){

        if (null != cursor){
            postOrderPrint(cursor.left);
            postOrderPrint(cursor.right);
            System.out.println(cursor.data);

        }
    }

    public static void levelOrderPrint(Node cursor){

        Queue<Node> queue = new LinkedList<Node>();
        Queue<Integer> levelQueue = new LinkedList<Integer>();

        queue.add(cursor);
        Node next;
        levelQueue.add(1);
        int currentLevel = 1;

        while ((next = queue.poll()) != null){
            int levelFromQueue = levelQueue.poll();
            if (currentLevel ==levelFromQueue) {
                System.out.print(next.data + " ");
            }else{
                System.out.println("");
                currentLevel = levelFromQueue;
                System.out.print(next.data + " ");
            }
            if (null != next.left) {
                queue.add(next.left);
                levelQueue.add(currentLevel + 1);
            }

            if (null != next.right) {
                queue.add(next.right);
                levelQueue.add(currentLevel + 1);
            }
        }
    }

    public static boolean isBalance(Node node){

        if (null != node) {
            if ((node.left != null && node.right == null) || (node.left == null && node.right != null))
                return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        return isBalance(node.left) && isBalance(node.right);
    }

    public static int maxDepth(Node root){
        if (null == root){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static int minDepth(Node root){
        if (null == root){
            return 0;
        }
        return Math.min(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args){

        testTravel();

    }

    public static void testTravel(){

        Node root = new Node();
        root.data = 1;

        Node left = new Node();
        left.data = 2;

        Node right = new Node();
        right.data = 3;

        root.left = left;
        root.right = right;

        Node leaf1 = new Node();
        leaf1.data = 4;
        leaf1.left = null;
        leaf1.right = null;

        Node leaf2 = new Node();
        leaf2.data = 5;
        leaf2.left = null;
        leaf2.right = null;

        left.left = leaf1;
        left.right = leaf2;

        Node leaf3 = new Node();
        leaf3.data = 6;
        leaf3.left = null;
        leaf3.right = null;

        Node leaf4 = new Node();
        leaf4.data = 7;
        leaf4.left = null;
        leaf4.right = null;

        right.left = leaf3;
        right.right = leaf4;

        System.out.println("first print");
        Node cursor = root;
        preOrderPrint(cursor);

        System.out.println("middle print");
        cursor = root;
        inOrderPrint(cursor);

        System.out.println("last print");
        cursor = root;
        postOrderPrint(cursor);

        System.out.println("level print");
        cursor = root;
        levelOrderPrint(cursor);

        cursor = root;
        if (isBalance(cursor)){
            System.out.println("balance");
        }
    }

    /**
     *
     * @param a node A
     * @param b node B
     * @return the common ancestor of a and b
     */
    public static Node findCommonAncestor(final Node a, final Node b){
        Set<Node> parentsA = new HashSet<Node>();

        Node cursor = a;

        while (null != cursor){
                parentsA.add(cursor);
                cursor = cursor.parent;
        }

        cursor = b;
        Node commonAncestor = null;

        while (null != cursor){
                if (parentsA.contains(cursor)) {
                    commonAncestor = cursor;
                    break;
                }
                cursor = cursor.parent;
        }

        return commonAncestor;

    }

    /**
     *
     * @param root - root node
     * @param nodeToCheck  the node to check
     * @return true if the nodeToCheck is Node under the branch starting from node root; otherwise false
     */
    public static boolean isChild(Node root, Node nodeToCheck){
        if (null == root){
            return false;
        }
        return (root == nodeToCheck) || isChild(root.left,nodeToCheck) || isChild(root.right, nodeToCheck);
    }

    /**
     * the method find the closest ancestor of Node A and Node B without depending on parent link
     * @param root root of the branch
     * @param a Node a
     * @param b Node b
     * @return the closed common ancestor of Node A and Node B
     */
    public static Node findCommonAncestor(final Node root, final Node a, final Node b){
        if (null == root || a == null || b == null){
            return null;
        }
        final Node cursor = root;
        if (isChild(cursor.left, a) && isChild(cursor.left, b)){
            return findCommonAncestor(cursor.left, a, b);
        }else if (isChild(cursor.right, a) && isChild(cursor.right, b)){
            return findCommonAncestor(cursor.right, a, b);
        }
        return cursor;
    }

    public static boolean isSubTree(final Node mainNode, final Node subNode){
        if (null == mainNode){
            return false;
        }
        if (null == subNode){
            return true;
        }
        if (mainNode.data == subNode.data){
            return isTreeMatched(mainNode, subNode);
        }
        return isSubTree(mainNode.left, subNode) || isSubTree(mainNode.right, subNode);
    }

    /**
     *
     * @param a A branch
     * @param b B branch
     * @return true if branch a matches branch b
     */
    public static boolean isTreeMatched(Node a, Node b){
        if (null == a && null == b){
            return true;
        }
        if (null == a || null == b){
            return false;
        }
        if (a.data == b.data){
            return isTreeMatched(a.left, b.left) && isTreeMatched(a.right, b.right);
        }else {
            return false;
        }
    }


}
