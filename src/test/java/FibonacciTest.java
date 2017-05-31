import junit.framework.TestCase;
import org.junit.Assert;

public class FibonacciTest extends TestCase {

    public void testGet() throws Exception {
        int f = Fibonacci.get(2);
        Assert.assertTrue(1 == f);

        f = Fibonacci.get(6);
        Assert.assertTrue(8 == f);

        f = Fibonacci.get(12);
        Assert.assertTrue(144 == f);

        f = Fibonacci.fibo(2);
        Assert.assertTrue(1 == f);

        f = Fibonacci.fibo(6);
        Assert.assertTrue(8 == f);

        f = Fibonacci.fibo(12);
        Assert.assertTrue(144 == f);
    }
}