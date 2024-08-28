import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int minLeft = 0, minRight = 0;
        int left = 0, right = n-1;

        while(left < right && right < n){
            int sum = arr[left] + arr[right];
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                minLeft = arr[left];
                minRight = arr[right];
            }
            
            if(sum < 0){
                left++;
            } else if(sum > 0){
                right--;
            } else {
                break;
            }
        }

        System.out.print(minLeft+" "+minRight);
    }
}
