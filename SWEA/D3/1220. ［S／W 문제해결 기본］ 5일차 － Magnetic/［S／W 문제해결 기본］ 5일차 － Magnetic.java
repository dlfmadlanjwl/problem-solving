import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
        	sc.nextInt();
            String[] input = new String[100];
            for(int i=0;i<100;i++){
            	for(int j=0;j<100;j++){
                	int n = sc.nextInt();
                    if(n!=0) input[j] += n;
                }
            }
            int count = 0;
            for(int i=0;i<100;i++){
            	count = count + ((input[i].length() - input[i].replace("12","").length()) / 2);
            }
            
            System.out.println("#"+test_case+" "+count);
        }
	}
}