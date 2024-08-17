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
            System.out.print("#"+test_case+" ");
            for(char c : input.toCharArray()){
            	if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
                System.out.print(c);
            }
            System.out.println();
		}
	}
}