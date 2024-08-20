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
            String input = sc.next();
            int a = 1, b = 1;
            for(char c : input.toCharArray()){
            	if(c == 'L'){
                	b = a+b;
                } else if(c == 'R'){
                	a = a+b;
                }
            }
            System.out.println("#"+test_case+" "+a+" "+b);
		}
	}
}