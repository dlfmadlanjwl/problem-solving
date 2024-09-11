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
            int[] count = new int[10];
            for(char c : input.toCharArray()){
            	count[c-'0']++;
            }
            int answer = 0;
            for(int i=0;i<10;i++){
                if(count[i] % 2 == 1) answer++;
            }
            System.out.println("#"+test_case+" "+answer);
		}
	}
}