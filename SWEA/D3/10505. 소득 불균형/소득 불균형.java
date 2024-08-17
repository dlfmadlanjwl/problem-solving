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
            int n = sc.nextInt();
            int sum = 0;
            int[] input = new int[n];
            for(int i=0;i<n;i++) {
            	input[i] = sc.nextInt();
                sum += input[i];
            }
            
            int count = 0;
            for(int i=0;i<n;i++) {
            	if(input[i] <= (double)sum/n) count++;
            }
            System.out.println("#"+test_case+" "+count);
		}
	}
}