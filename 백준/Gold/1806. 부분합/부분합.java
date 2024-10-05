import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        int min = Integer.MAX_VALUE;
        int sum = arr[0];
        while(left <= right && right < arr.length){
            if(sum < s){
                right++;
                if(right < arr.length) sum += arr[right];
            } else if(sum > s){
                min = Math.min(min, right - left + 1);
                sum -= arr[left];
                left++;
            } else {
                min = Math.min(min, right - left + 1);
                right++;
                if(right < arr.length) sum += arr[right];
            }
        }

        if(min == Integer.MAX_VALUE) System.out.print(0);
        else System.out.print(min);
    }
}