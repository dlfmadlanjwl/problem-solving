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
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            
			for(int i=0;i<10;i++){
            	String input = sc.next();
                int sum = 0;
                for(char c : input.toCharArray()){
                	sum += c - '0';
                }
                max = Math.max(max, sum);
                min = Math.min(min, sum);
            }
            System.out.println("#"+test_case+" "+max+" "+min);
		}
	}
}