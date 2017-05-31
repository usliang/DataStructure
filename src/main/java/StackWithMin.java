import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
    public StackWithMin() {
        super();
    }

    public void push(int data) {
        int minCurrent = min();

        if (data < minCurrent) {
            minCurrent = data;
        }
        super.push(new NodeWithMin(data, minCurrent));
    }

    public int min() {
        if (super.empty()) {
            return Integer.MIN_VALUE;
        } else {
            NodeWithMin nodeWithMin = super.peek();
            return nodeWithMin.getMin();
        }
    }

    public static Stack<Integer> sortStack(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while (!s.isEmpty()) {
            Integer tmp = s.pop();

            while (!r.isEmpty() && r.peek() < tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }

        return r;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();

        s.push(10);
        s.push(4);
        s.push(6);
        s.push(12);
        s.push(23);

        Stack<Integer> r = sortStack(s);

    }

}