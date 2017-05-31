/**
 * Created by lliang on 5/23/2017.
 */
public class Fibonacci {
    public static int get(int n) {
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return 1;
        }
        if (0 > n) {
            return -1; //error
        }
        return get(n - 1) + get(n - 2);
    }

    public static int fibo(int n) {
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return 1;
        }
        if (0 > n) {
            return -1; //error
        }

        int a = 1;
        int b = 1;

        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

}
