import java.util.Stack;

/**
 * Created by liliang on 5/2/17.
 * CopyRight Apple Inc.
 */
public class Tower {
    Stack<Integer> stack;
    int index;

    public Tower(Stack<Integer> stack, int index) {
        this.stack = stack;
        this.index = index;
    }

    public void push(Integer disk){
        stack.push(disk);
    }

    public void popTop(Tower tower){

        System.out.println("move disk: " + stack.peek() + " from tower: " + index + " to tower: " + tower.index);
        tower.push(stack.pop());
    }

    public void move(int stickCount, Tower target, Tower buffer){
        if (stickCount>0){
            move(stickCount-1, buffer, target);
            popTop(target);
            buffer.move(stickCount-1, target, this);
        }
    }

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        Tower tower1 = new Tower(stack, 1);

        stack = new Stack<Integer>();
        Tower tower2 = new Tower(stack, 2);

        stack = new Stack<Integer>();
        Tower tower3 = new Tower(stack, 3);

        tower1.push(7);
        tower1.push(5);
        tower1.push(3);
        tower1.push(1);
        tower1.move(4, tower3, tower2);
    }
}
