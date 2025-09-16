import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    private static int[] choices;
    private static boolean[] isVisited;
    private static boolean[] isFinished;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            choices = new int[n + 1];
            isVisited = new boolean[n + 1];
            isFinished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                choices[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!isVisited[i]) {
                    dfs(i);
                }
            }
            System.out.println(n - count);
        }
    }

    private static void dfs(int current) {
        isVisited[current] = true;
        int next = choices[current];
        if (!isVisited[next]) {
            dfs(next);
        } else {
            if (!isFinished[next]) {
                count++;
                int cycle = choices[next];
                while (cycle != next) {
                    count++;
                    cycle = choices[cycle];
                }
            }
        }
        isFinished[current] = true;
    }
}