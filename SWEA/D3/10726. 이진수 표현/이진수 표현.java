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
            int x = (1 << n) - 1;
            System.out.print("#"+test_case+" ");
            if((x & m) == x){
            	System.out.println("ON");
            }  else System.out.println("OFF");
		}
	}
}