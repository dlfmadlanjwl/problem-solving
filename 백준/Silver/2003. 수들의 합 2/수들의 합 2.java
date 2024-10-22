import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            if(i == 1) arr[i] = Integer.parseInt(st.nextToken());
            else arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 1;
        int answer = 0;
        while(left <= right && right < arr.length){
            int sum = arr[right] - arr[left];
            if(sum < m){
                right++;
            } else if (sum > m){
                left++;
            } else {
                answer++;
                right++;
            }
        }

        System.out.print(answer);
    }
}