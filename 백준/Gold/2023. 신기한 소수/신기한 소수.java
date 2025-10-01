import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    private static int n;
    private static final List<Integer> primeNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= 9; i++) {
            if (isPrimeNumber(i)) {
                dfs(i);
            }
        }

        primeNumbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void dfs(int number) {
        String rawNumber = String.valueOf(number);
        if (rawNumber.length() == n) {
            primeNumbers.add(Integer.parseInt(rawNumber));
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if(i % 2 == 0) continue;
            int nextNumber = Integer.parseInt(rawNumber + i);
            if (isPrimeNumber(nextNumber)) {
                dfs(nextNumber);
            }
        }
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 0 || number == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}