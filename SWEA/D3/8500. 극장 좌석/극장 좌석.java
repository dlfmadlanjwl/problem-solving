import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
           
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
            	arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            
            int sum = 0;
            int left = 0;
            for(int i=0;i<n;i++){
                int x = arr[i];
                if(x > left) sum += x - left + 1 + x;
                    else sum += 1 + x;
                    left = x;
			}
            System.out.println("#"+test_case+" "+sum);
		}
	}
}