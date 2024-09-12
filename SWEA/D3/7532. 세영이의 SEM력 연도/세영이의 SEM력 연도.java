import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int s = sc.nextInt();
            int e = sc.nextInt();
            int m = sc.nextInt();
            
            int year = s;
			while(true){
            	if((year-e) % 24 == 0 && (year-m) % 29 == 0){
                    System.out.println("#"+test_case+" "+year);
                    break;
                }
                year += 365;
            }
		}
	}
}