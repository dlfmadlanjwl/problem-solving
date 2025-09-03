import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        int answer = calculateContinuedSum(numbers);
        System.out.println(answer);
    }

    private static int calculateContinuedSum(List<Integer> numbers) {
        List<Integer> maxNumbers = new ArrayList<>(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            int maxNumber = Math.max(maxNumbers.get(i - 1) + numbers.get(i), numbers.get(i));
            maxNumbers.set(i, maxNumber);
        }
        return maxNumbers.stream().mapToInt(i -> i).max().orElse(0);
    }
}