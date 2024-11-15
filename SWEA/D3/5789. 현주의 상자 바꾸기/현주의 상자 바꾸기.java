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
            int q = sc.nextInt();
            int[] arr = new int[n+1];
            for(int i=1;i<=q;i++){
            	int l = sc.nextInt();
                int r = sc.nextInt();
                for(int j=l;j<=r;j++){
                	arr[j] = i;
                }
            }
            System.out.print("#"+test_case+" ");
            for(int i=1;i<=n;i++){
            	System.out.print(arr[i]+" ");
            }
            System.out.println();
		}
	}
}