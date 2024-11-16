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
            for(int i=0;i<input.length();i++){
            	if(input.charAt(i) == ('a'+i)){
                	count++;
                } else {
                	break;
                }
            }
            System.out.println("#"+test_case+" "+count);
		}
	}
}