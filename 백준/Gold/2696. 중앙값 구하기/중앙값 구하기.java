import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        for (int currentT = 0; currentT < t; currentT++) {
            int m = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            System.out.println(m / 2 + 1);
            for (int i = 0; i < m; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                int x = Integer.parseInt(st.nextToken());
                if (maxHeap.size() <= minHeap.size()) {
                    maxHeap.add(x);
                }
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(x);
                }
                if (!(minHeap.isEmpty() || maxHeap.isEmpty())) {
                    if (maxHeap.peek() > minHeap.peek()) {
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(minHeap.poll());
                    }
                }
                if (i % 2 == 0) {
                    System.out.print(maxHeap.peek() + " ");
                }
            }
            System.out.println();
        }
    }
}