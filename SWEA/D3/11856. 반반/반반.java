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
            System.out.print("#"+test_case+" ");
            if(input.charAt(0) == input.charAt(1) && input.charAt(2) == input.charAt(3) && input.charAt(0) != input.charAt(2)){
            	System.out.println("Yes");
            } else if(input.charAt(0) == input.charAt(2) && input.charAt(1) == input.charAt(3) && input.charAt(0) != input.charAt(1)){
            	System.out.println("Yes");
            } else if(input.charAt(0) == input.charAt(3) && input.charAt(1) == input.charAt(2) && input.charAt(0) != input.charAt(1)){
            	System.out.println("Yes");
            } else System.out.println("No");
		}
	}
}