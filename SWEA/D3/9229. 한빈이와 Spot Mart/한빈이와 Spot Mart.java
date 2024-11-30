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
            int left = 0;
            int right = arr.length-1;
            int max = -1;
            while(left < right){
            	if(arr[left] + arr[right] > m){
                	right--;
                } else if(arr[left] + arr[right] < m){
                    max = Math.max(max, arr[left] + arr[right]);
                	left++;
                } else {
                    max = Math.max(max, arr[left] + arr[right]);
                	break;
                }
            }
            System.out.println("#"+test_case+" "+max);
		}
	}
}