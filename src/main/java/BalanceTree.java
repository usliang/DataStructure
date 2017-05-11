/**
 * Created by liliang on 5/10/17.
 * CopyRight Apple Inc.
 */
import java.util.LinkedList;
import java.util.Queue;

public class BalanceTree {

    static class Node{
        int data;
        Node left;
        Node right;


    }
    Node root;

    public static void firstPrint(Node cursor){

        if (null != cursor){
            System.out.println(cursor.data);
            firstPrint(cursor.left);
            firstPrint(cursor.right);
        }
    }

    public static void middlePrint(Node cursor){

        if (null != cursor){
            middlePrint(cursor.left);
            System.out.println(cursor.data);
            middlePrint(cursor.right);
        }
    }

    public static void lastPrint(Node cursor){

        if (null != cursor){
            lastPrint(cursor.left);
            lastPrint(cursor.right);
            System.out.println(cursor.data);

        }
    }

    public static void levelPrint(Node cursor){

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
        boolean ret = true;

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
        firstPrint(cursor);

        System.out.println("middle print");
        cursor = root;
        middlePrint(cursor);

        System.out.println("last print");
        cursor = root;
        lastPrint(cursor);

        System.out.println("level print");
        cursor = root;
        levelPrint(cursor);

        cursor = root;
        if (isBalance(cursor)){
            System.out.println("balance");
        }

    }
}
