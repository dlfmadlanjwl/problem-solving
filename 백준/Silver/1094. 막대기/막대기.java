import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(64);

        while(true){
            int sum = 0;
            for(int n : pq){
                sum += n;
            }
            if(sum > x){
                int min = pq.poll();
                if(sum - min / 2 >= x){
                    pq.add(min / 2);
                } else {
                    pq.add(min / 2);
                    pq.add(min / 2);
                }
            } else if(sum == x){
                break;
            }
        }

        System.out.print(pq.size());
    }
}