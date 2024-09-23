import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long[] scores = new long[n];
        long max = Long.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            scores[i] = Long.parseLong(st.nextToken());
            max = Math.max(max, scores[i]);
        }

        long answer = binarySearch(0, max, k, scores);
        System.out.print(answer);
    }

    static long binarySearch(long left, long right, long k, long[] scores){
        while(left < right){
            long mid = (left + right) / 2;
            long candy = 0;
            for(long score : scores){
                if(score > mid) candy += score - mid;
            }

            if(candy > k){
                left = mid + 1;
            } else if(candy < k){
                right = mid;
            } else {
                return mid;
            }
        }

        return right;
    }
}