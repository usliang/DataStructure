import java.util.*;

/**
 * Created by lliang on 4/29/2017.
 */
public class Solution {
    class Item implements Comparator<Item> {
        int begin;
        int end;
        long val;
        Item next;

        @Override
        public int compare(Item o1, Item o2) {
            return o1.end - o2.end;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            if (begin != item.begin) return false;
            if (end != item.end) return false;
            if (val != item.val) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = begin;
            result = 31 * result + end;
            result = 31 * result + (int) (val ^ (val >>> 32));
            return result;
        }

        @Override
        public String toString() {
            Item cursor = this;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("+++++++++\n");
            while (null != cursor) {
                stringBuffer.append(cursor.begin + ":" + cursor.end + " " + cursor.val + "\n");
                cursor = cursor.next;
            }
            stringBuffer.append("----------\n");
            return stringBuffer.toString();
        }

    }

    Item root = null;


    long max;

    public Solution(int size) {
        root = new Item();
        root.begin = 0;
        root.end = size - 1;
        root.val = 0;
        root.next = null;
        max = 0;
        System.out.println(root);
    }

    void addItem(Item itemToAdd) {

        System.out.println("max " + max);

        System.out.println("To add: " + itemToAdd);

        Item cursor = root;
        Item prev = root;
        while (null != cursor && cursor.end < itemToAdd.begin) {
            prev = cursor;
            cursor = cursor.next;
        }

        Item item;
        if (null == cursor) {
            item = prev;
        } else {
            item = cursor;
        }

        while (item != null && itemToAdd.end >= item.begin) {

            if ((itemToAdd.begin == item.begin) && (itemToAdd.end == item.end)) {
                item.val += itemToAdd.val;
                if (max < item.val) {
                    max = item.val;
                }

                System.out.println(root);

                break;
            }


            if ((itemToAdd.begin <= item.begin) && (itemToAdd.end >= item.end)) {
                item.val += itemToAdd.val;
                item = item.next;

                if (max < item.val) {
                    max = item.val;
                }

                System.out.println(root);

                continue;
            }

            if ((itemToAdd.begin > item.begin) && (itemToAdd.end < item.end)) {

                int oldEnd = item.end;
                item.end = itemToAdd.begin - 1;

                Item newItem2 = new Item();
                newItem2.begin = itemToAdd.begin;
                newItem2.end = itemToAdd.end;
                newItem2.val = item.val + itemToAdd.val;

                if (max < newItem2.val) {
                    max = newItem2.val;
                }

                Item newItem3 = new Item();
                newItem3.begin = itemToAdd.end + 1;
                newItem3.end = oldEnd;
                newItem3.val = item.val;

                newItem3.next = item.next;
                item.next = newItem2;
                newItem2.next = newItem3;

                System.out.println(root);

                break;
            }

            if ((itemToAdd.begin <= item.begin) && (itemToAdd.end < item.end) && (itemToAdd.end >= item.begin)) {
                int oldEnd = item.end;
                item.end = itemToAdd.end;
                long oldVal = item.val;
                item.val = item.val + itemToAdd.val;

                if (max < item.val) {
                    max = item.val;
                }

                Item newItem2 = new Item();
                newItem2.begin = itemToAdd.end + 1;
                newItem2.end = oldEnd;
                newItem2.val = oldVal;

                newItem2.next = item.next;
                item.next = newItem2;

                System.out.println(root);
                break;
            }

            if ((itemToAdd.begin > item.begin) && (itemToAdd.end >= item.end) && (item.end >= itemToAdd.begin)) {
                int oldEnd = item.end;
                item.end = itemToAdd.begin - 1;

                Item newItem2 = new Item();
                newItem2.begin = itemToAdd.begin;
                newItem2.end = oldEnd;
                newItem2.val = item.val + itemToAdd.val;

                if (max < newItem2.val) {
                    max = newItem2.val;
                }

                newItem2.next = item.next;
                item.next = newItem2;

                System.out.println(root);
                item = newItem2;
            }
        }

    }

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        int size = 0;
        if (stdin.hasNextInt()) {
            size = stdin.nextInt();
        }

        Solution spArray = new Solution(size);

        int m = 0;
        if (stdin.hasNextInt()) {
            m = stdin.nextInt();
        }

        int a = 0;
        int b = 0;
        int k = 0;


        Item item;
        for (int i = 0; i < m; i++) {
            System.out.println("i: " + i);
            if (stdin.hasNextInt()) {
                a = stdin.nextInt();
            }
            if (stdin.hasNextInt()) {
                b = stdin.nextInt();
            }
            if (stdin.hasNextInt()) {
                k = stdin.nextInt();
            }

            item = spArray.new Item();
            item.begin = a - 1;
            item.end = b - 1;
            item.val = k;

            spArray.addItem(item);

        }

        stdin.close();

        System.out.println(spArray.max);

    }

}
