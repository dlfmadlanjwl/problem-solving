import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        BigInteger n = scanner.nextBigInteger();
        BigInteger m = scanner.nextBigInteger();

        System.out.println(n.divide(m));
        System.out.print(n.remainder(m));
    }
}
