import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        boolean[] currentIsTurnOn1 = new boolean[n];
        boolean[] currentIsTurnOn2 = new boolean[n];
        boolean[] goalIsTurnOn = new boolean[n];
        char[] input1 = bufferedReader.readLine().toCharArray();
        char[] input2 = bufferedReader.readLine().toCharArray();
        for (int i = 0; i < input1.length; i++) {
            currentIsTurnOn1[i] = input1[i] == '0';
            currentIsTurnOn2[i] = input1[i] == '0';
            goalIsTurnOn[i] = input2[i] == '0';
        }

        int count1 = 0;
        int count2 = 1;
        currentIsTurnOn2[0] = !currentIsTurnOn2[0];
        currentIsTurnOn2[1] = !currentIsTurnOn2[1];

        for (int i = 1; i < n; i++) {
            if (currentIsTurnOn1[i - 1] != goalIsTurnOn[i - 1]) {
                reverse(currentIsTurnOn1, i);
                count1++;
            }
            if (currentIsTurnOn2[i - 1] != goalIsTurnOn[i - 1]) {
                reverse(currentIsTurnOn2, i);
                count2++;
            }
        }

        if (currentIsTurnOn1[n - 1] != goalIsTurnOn[n - 1]) {
            count1 = Integer.MAX_VALUE;
        }
        if (currentIsTurnOn2[n - 1] != goalIsTurnOn[n - 1]) {
            count2 = Integer.MAX_VALUE;
        }
        if (count1 == count2 && count1 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(count1, count2));
        }
    }

    private static void reverse(boolean[] isTurnOn, int idx) {
        isTurnOn[idx] = !isTurnOn[idx];
        isTurnOn[idx - 1] = !isTurnOn[idx - 1];
        if (idx + 1 < isTurnOn.length) {
            isTurnOn[idx + 1] = !isTurnOn[idx + 1];
        }
    }
}
