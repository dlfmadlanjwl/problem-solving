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
            int m = sc.nextInt();
            int personCount = 0;
            int maxProblemCount = 0;
            for(int i=0;i<n;i++){
                int count = 0;
            	for(int j=0;j<m;j++){
                	if(sc.nextInt() == 1) count++;
                }
                if(count > maxProblemCount){
                	maxProblemCount = count;
                    personCount = 1;
                } else if(count == maxProblemCount){
                	personCount++;
                }
            }
            
            System.out.println("#"+test_case+" "+personCount+" "+maxProblemCount);
		}
	}
}