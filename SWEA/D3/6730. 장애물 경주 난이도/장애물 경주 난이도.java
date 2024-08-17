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
            int up = 0, down = 0;
            int previous = sc.nextInt();
            for(int i=0;i<n-1;i++){
                int x = sc.nextInt();
            	if(previous < x){
                	up = Math.max(up, x-previous);
                } else {
                	down = Math.max(down, previous-x);
                }
                previous = x;
            }
            System.out.println("#"+test_case+" "+up+" "+down);
		}
	}
}