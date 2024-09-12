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
            int m = sc.nextInt();
            System.out.print("#"+test_case+" ");
            for(int twin=0;twin<=m;twin++){
            	int unicon = n - 2 * twin;
                if(unicon + twin == m) {
                	System.out.println(unicon+" "+twin);
                    break;
                }
            }
		}
	}
}