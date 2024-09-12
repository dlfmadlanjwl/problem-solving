import java.util.Scanner;

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
            int[] input = new int[n];
            for(int i=0;i<n;i++){
            	input[i] = sc.nextInt();
            }
            
            int count = 0;
            for(int i=1;i<n-1;i++){
            	int max = Math.max(input[i-1], Math.max(input[i], input[i+1]));
                int min = Math.min(input[i-1], Math.min(input[i], input[i+1]));
                if(input[i] != max && input[i] != min) count++;
            }
            System.out.println("#"+test_case+" "+count);
		}
	}
}