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
			int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            int count = 0;
            while(x <= n && y <= n){
            	if(x < y){
                	x += y;
                } else {
                	y += x;
                }
                count++;
            }
            System.out.println(count);
		}
	}
}