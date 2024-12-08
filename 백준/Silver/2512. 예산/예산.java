import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            int input = Integer.parseInt(st.nextToken());
            sum += input;
            max = Math.max(max, input);
            arr[i] = input;
        }
        int m = Integer.parseInt(br.readLine());

        if(sum <= m){
            System.out.print(max);
            return;
        }

        int mid = binarySearch(arr, max, m);
        System.out.print(mid);
    }

    static int binarySearch(int[] arr, int max, int m){
        int left = 0;
        int right = max;

        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for(int i=0;i<arr.length;i++){
                if(mid < arr[i]){
                    sum += mid;
                } else sum += arr[i];
            }

            if(sum > m){
                right = mid - 1;
            } else if(sum < m){
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return right;
    }
}