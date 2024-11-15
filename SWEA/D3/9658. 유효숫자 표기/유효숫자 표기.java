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
            String input = sc.next();
			int left = Integer.parseInt(input.substring(0, 3));
            String right = input.substring(3);
            left = (int)Math.round((double)left / 10) * 10;
            String rawAnswer = String.valueOf(left) + right;
            System.out.println("#"+test_case+" "+rawAnswer.charAt(0)+"."+rawAnswer.charAt(1)+"*10^"+(rawAnswer.length()-1));
		}
	}
}