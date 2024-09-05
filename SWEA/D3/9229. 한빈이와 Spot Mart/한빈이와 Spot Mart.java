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
            int m = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
            	arr[i] = sc.nextInt();
            }
            
            Arrays.sort(arr);
            int max = 0;
            int left = 0, right = arr.length-1;
            while(left < right){
            	if(arr[left] + arr[right] > m){
                	right--;
                } else if(arr[left] + arr[right] < m){
                    max = Math.max(arr[left] + arr[right], max);
                	left++;
                } else {
                	max = m;
                    break;
                }
            }
            
            System.out.print("#"+test_case+" ");
            if(max == 0) System.out.println(-1);
            else System.out.println(max);
		}
	}
}