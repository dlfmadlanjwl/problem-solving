import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
            String input = sc.next();
            int sum = 0;
            for(char c : input.toCharArray()){
                if(0 <= c - '0' && c - '0' <= 9){
                	sum += c - '0';
                }
            }
            System.out.println("#"+test_case+" "+sum);
		}
	}
}