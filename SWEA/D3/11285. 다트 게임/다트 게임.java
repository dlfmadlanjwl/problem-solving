import java.util.*;

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
            int sum = 0;
            for(int i=0;i<n;i++){
            	int x = sc.nextInt();
                int y = sc.nextInt();
                int[] scores = {20,40,60,80,100,120,140,160,180,200};
                int len = x * x + y * y;
               	for(int j=0;j<scores.length;j++){
               		if(len <= scores[j] * scores[j]){
                    	sum += 11 - scores[j] / 20;
                        break;
                    }
               	}
            }
            System.out.println("#"+test_case+" "+sum);
		}
	}
}