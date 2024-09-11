import java.util.*;

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
            int left = 0, right = 0, ball = 0;
            for(int i=0;i<input.length();i++){
            	if(input.charAt(i) == '(') left++;
                if(input.charAt(i) == ')') right++;
                if(input.length() > i+1 && input.substring(i, i+2).equals("()")) ball++;
            }
            int count = left + right - ball;
            System.out.println("#"+test_case+" "+count);
        }
	}
}