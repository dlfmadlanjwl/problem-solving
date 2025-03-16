import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] times = new int[n];
            for (int i = 0; i < n; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            int[] counts = new int[n];
            List<Integer>[] routes = new List[n];
            for (int i = 0; i < n; i++) {
                routes[i] = new ArrayList<>();
            }
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                counts[y - 1]++;
                routes[x - 1].add(y - 1);
            }

            int w = Integer.parseInt(br.readLine()) - 1;

            int answer = topologicalSort(counts, routes, times, w);
            System.out.println(answer);
        }
    }

    private static int topologicalSort(int[] counts, List<Integer>[] routes, int[] times, int w) {
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[counts.length];
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                result[i] = times[i];
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : routes[current]) {
                result[next] = Math.max(result[next], result[current] + times[next]);
                counts[next]--;
                if (counts[next] == 0) {
                    q.offer(next);
                }
            }
        }
        
        return result[w];
    }
}