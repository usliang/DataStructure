import java.io.Console;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by lliang on 4/29/2017.
 */
public class Hanoni {
    Stack<Integer>[] stacks;

    public Hanoni(Stack<Integer>[] stacks){
        this.stacks = stacks;
    }

    public boolean move2To3(){
        //try to move find a dish to move
        boolean result = false;
        if (!stacks[1].isEmpty()){
            int topIn1 = stacks[1].peek();
            //try move to s3
            if (stacks[2].isEmpty()){
                stacks[2].push(stacks[1].pop());
                result = true;
            }else {
                int topIn2 = stacks[2].peek();
                if (topIn1<topIn2){
                    stacks[2].push(stacks[1].pop());
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean move2To1(){
        //try to move find a dish to move
        boolean result = false;
        if (!stacks[1].isEmpty()){
            int topIn1 = stacks[1].peek();
            //try move to s3
            if (stacks[0].isEmpty()){
                stacks[0].push(stacks[1].pop());
                result = true;
            }else {
                int topIn0 = stacks[0].peek();
                if (topIn1<topIn0){
                    stacks[0].push(stacks[1].pop());
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean move1To2(){
        //try to move find a dish to move
        boolean result = false;
        if (!stacks[0].isEmpty()){
            int topIn0 = stacks[0].peek();
            //try move to s2
            if (stacks[1].isEmpty()){
                stacks[1].push(stacks[0].pop());
                result = true;
            }else {
                int topIn1 = stacks[1].peek();
                if (topIn0<topIn1){
                    stacks[1].push(stacks[0].pop());
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean move3To2(){
        //try to move find a dish to move
        boolean result = false;
        if (!stacks[2].isEmpty()){
            int topIn2 = stacks[2].peek();
            //try move to s2
            if (stacks[1].isEmpty()){
                stacks[1].push(stacks[2].pop());
                result = true;
            }else {
                int topIn1 = stacks[1].peek();
                if (topIn2<topIn1){
                    stacks[1].push(stacks[2].pop());
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean isDone(){
      return stacks[0].isEmpty() && stacks[1].isEmpty();
    }

    static int summation(int[] numbers) {
        int sum =0;
        for (int i=0; i<numbers[0]; i++){
            sum += numbers[i+1];
        }
        return sum;

    }

    public static void testHanoni(){
        Stack<Integer>[] stacks = new Stack[3];
        stacks[0].push(5);
        stacks[0].push(3);
        stacks[0].push(1);

        Hanoni hanoni = new Hanoni(stacks);

        hanoni.move1To2();
        hanoni.move2To3();
        hanoni.move1To2();

    }
    public static void main(String[] args){

        testHanoni();

    }
}
