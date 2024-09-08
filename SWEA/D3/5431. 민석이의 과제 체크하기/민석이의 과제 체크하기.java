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
            int k = sc.nextInt();
            
            boolean[] submitted = new boolean[n+1];
            for(int i=0;i<k;i++){
            	submitted[sc.nextInt()] = true;
            }
            
            System.out.print("#"+test_case+" ");
            for(int i=1;i<=n;i++){
            	if(!submitted[i]) System.out.print(i+" ");
            }
            System.out.println();
		}
	}
}