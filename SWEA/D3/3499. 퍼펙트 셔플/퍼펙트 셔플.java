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
			int n = sc.nextInt();
            String[] input = new String[n];
            for(int i=0;i<n;i++){
            	input[i] = sc.next();
            }
            
            String[] answer = new String[n];
            System.out.print("#"+test_case+" ");
            for(int i=0;i<n;i++){
            	if(i % 2 == 0){
                	System.out.print(input[i/2]+" ");
                } else {
                	System.out.print(input[(int)Math.ceil((double)n/2)+i/2]+" ");
                }
            }
            System.out.println();
		}
	}
}