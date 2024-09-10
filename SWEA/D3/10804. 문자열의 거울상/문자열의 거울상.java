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
			String input = sc.next();
            StringBuilder sb = new StringBuilder();
            for(char c : input.toCharArray()){
            	if(c == 'b') sb.append('d');
                else if(c == 'd') sb.append('b');
                else if(c == 'p') sb.append('q');
                else if(c == 'q') sb.append('p');
            }
            System.out.println("#"+test_case+" "+sb.reverse());
		}
	}
}