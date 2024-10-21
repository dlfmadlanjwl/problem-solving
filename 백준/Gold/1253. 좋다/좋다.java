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
        int answer = 0;
        for(int i=0;i<n;i++){
            if(isGood(arr, arr[i], i)){
                answer++;
            }
        }
        System.out.print(answer);
    }

    static boolean isGood(int[] arr, int number, int index){
        int left = 0, right = arr.length-1;
        while(true){
            if(left == index) left++;
            if(right == index) right--;
            if(left >= right) break;
            int sum = arr[left] + arr[right];
            if(sum < number){
                left++;
            } else if(sum > number){
                right--;
            } else {
                return true;
            }
        }

        return false;
    }
}