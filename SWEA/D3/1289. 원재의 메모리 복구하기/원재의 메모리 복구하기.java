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
            int count = 0;
            if(input.charAt(0) == '1') count++;
            for(int i=1;i<input.length();i++){
            	if(input.charAt(i) != input.charAt(i-1)) count++;
            }
            System.out.println("#"+test_case+" "+count);
		}
	}
}