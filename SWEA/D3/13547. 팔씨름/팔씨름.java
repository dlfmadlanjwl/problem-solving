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
            int count = 0;
            System.out.print("#"+test_case+" ");
            for(char c : input.toCharArray()){
            	if(c == 'x') count++;
            }
            if(count >= 8) System.out.println("NO");
            else System.out.println("YES");
		}
	}
}