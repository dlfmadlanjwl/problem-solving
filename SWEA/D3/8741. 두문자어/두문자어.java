import java.util.Scanner;
import java.lang.StringBuilder;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String answer = "";
			for(int i=0;i<3;i++){
            	String input = sc.next();
                answer += (char)(input.charAt(0) - ('z' - 'a' + 7));
            }
            System.out.println("#"+test_case+" "+answer);
		}
	}
}