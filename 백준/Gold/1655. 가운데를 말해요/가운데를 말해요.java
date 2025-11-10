import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(bufferedReader.readLine()));
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer number : numbers) {
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(number);
            } else {
                minHeap.add(number);
            }
            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int mid1 = maxHeap.poll();
                    int mid2 = minHeap.poll();
                    maxHeap.add(mid2);
                    minHeap.add(mid1);
                }
            }
            System.out.println(maxHeap.peek());
        }
    }
}