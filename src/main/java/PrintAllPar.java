import java.util.ArrayList;
import java.util.List;

/**
 * Created by lliang on 5/28/2017.
 */
public class PrintAllPar {

    private static void printPar(final int l, final int r, final char[] str, final int count) {
        if (l < 0 || r < l) return; // invalid state
        if (l == 0 && r == 0) {
            System.out.println(str); // found one, so print it
        } else {
            if (l > 0) { // try a left paren, if there are some available
                str[count] = '(';
                printPar(l - 1, r, str, count + 1);
            }
            if (r > l) { // try a right paren, if there’s a matching left
                str[count] = ')';
                printPar(l, r - 1, str, count + 1);
            }
        }
    }

    public static void printPar(int count) {
        char[] str = new char[count*2];
        printPar(count, count, str, 0);
    }

    private static void printPar2(final int l, final int r, final char[] str, final int count, final List<String> pars) {
        if (l < 0 || r < l) return; // invalid state
        if (l == 0 && r == 0) {
            System.out.println(str); // found one, so print it
            pars.add(new String(str));
        } else {
            if (l > 0) { // try a left paren, if there are some available
                str[count] = '(';
                printPar2(l - 1, r, str, count + 1, pars);
            }
            if (r > l) { // try a right paren, if there’s a matching left
                str[count] = ')';
                printPar2(l, r - 1, str, count + 1, pars);
            }
        }
    }

    public static List<String> printPar2(int count) {
        char[] str = new char[count*2];
        List<String> pars = new ArrayList<>();
        printPar2(count, count, str, 0, pars);
        return pars;
    }
}
