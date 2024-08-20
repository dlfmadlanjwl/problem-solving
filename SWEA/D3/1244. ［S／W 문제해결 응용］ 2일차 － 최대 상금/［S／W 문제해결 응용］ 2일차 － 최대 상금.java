import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String input = sc.next();
            int n = sc.nextInt();
            int[] arr = new int[input.length()];
            for(int i=0;i<input.length();i++){
                arr[i] = input.charAt(i)-'0';
            }
            if(n > arr.length) n = arr.length;
            int answer = dfs(arr, 0, n);
            System.out.println("#"+test_case+" "+answer);
        }
    }

    static int dfs(int[] arr, int count, int target){
        if(target == count){
            int sum = 0;
            for(int i=0;i<arr.length;i++){
                sum += arr[i] * (int)Math.pow(10, arr.length-i-1);
            }
            return sum;
        }
        int max = 0;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                int result = dfs(arr, count+1, target);
                max = Math.max(max, result);
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        return max;
    }
}