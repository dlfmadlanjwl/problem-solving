import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    private static List<Integer>[] relations;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        relations = new List[n];
        for (int i = 0; i < relations.length; i++) {
            relations[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            relations[a].add(b);
            relations[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, 1, new boolean[n]);
        }
        System.out.println(answer);
    }

    private static void dfs(int now, int depth, boolean[] isVisited) {
        if (depth == 5) {
            answer = 1;
            return;
        }
        isVisited[now] = true;
        List<Integer> friends = relations[now];
        for (int friend : friends) {
            if (!isVisited[friend]) {
                dfs(friend, depth + 1, isVisited);
            }
        }
        isVisited[now] = false;
    }
}