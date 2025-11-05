import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        char[] input = bufferedReader.readLine().toCharArray();
        int[] numbers = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = input[i] - '0';
        }

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || stack.peek() >= numbers[i]) {
                stack.add(numbers[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < numbers[i] && count < k) {
                    stack.pop();
                    count++;
                }
                stack.add(numbers[i]);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n - k; i++) {
            stringBuilder.append(stack.get(i));
        }
        System.out.println(stringBuilder);
    }
}