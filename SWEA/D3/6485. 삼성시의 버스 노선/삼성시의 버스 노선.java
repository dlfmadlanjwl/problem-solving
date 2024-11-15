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
            int[] count = new int[5001];
			int n = sc.nextInt();
            for(int i=0;i<n;i++){
            	int a = sc.nextInt();
                int b = sc.nextInt();
                for(int j=a;j<=b;j++){
                	count[j]++;
                }
            }
            int p = sc.nextInt();
            System.out.print("#"+test_case+" ");
            for(int i=0;i<p;i++){
            	System.out.print(count[sc.nextInt()]+" ");
            }
            System.out.println();
		}
	}
}