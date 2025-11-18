import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        List<Number> input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input.add(new Number(i, Integer.parseInt(stringTokenizer.nextToken())));
        }
        List<Number> sortedInput = new ArrayList<>(input);
        sortedInput.sort((o1, o2) -> o1.value - o2.value);

        for (Number number : input) {
            System.out.print(sortedInput.indexOf(number) + " ");
        }
    }

    static class Number {
        int idx;
        int value;

        public Number(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}