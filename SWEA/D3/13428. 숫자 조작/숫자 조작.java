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
            int min = Integer.parseInt(input);
            int max = Integer.parseInt(input);
            for(int i=0;i<input.length();i++){
            	for(int j=i+1;j<input.length();j++){
                	String movedStr = input.substring(0, i) + input.charAt(j) + input.substring(i+1, j) + input.charAt(i)+input.substring(j+1, input.length());
                    if(movedStr.charAt(0) =='0') continue;
                    min = Math.min(min, Integer.parseInt(movedStr));
                    max = Math.max(max, Integer.parseInt(movedStr));
                }
            }
            System.out.println("#"+test_case+" "+min+" "+max);
		}
	}
}