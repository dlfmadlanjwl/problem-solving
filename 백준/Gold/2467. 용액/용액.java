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
        int left = 0;
        int right = n-1;
        int[] answer = {0, 0};
        int min = Integer.MAX_VALUE;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                answer = new int[]{arr[left], arr[right]};
            }

            if(sum > 0) right--;
            else if(sum < 0) left++;
            else break;
        }

        Arrays.sort(answer);
        System.out.print(answer[0] + " " + answer[1]);
    }
}