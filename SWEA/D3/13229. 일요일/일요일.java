import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		List<String> days = Arrays.asList("SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String input = sc.next();
           	int idx = days.indexOf(input);
            System.out.println("#"+test_case+" "+(7-idx));
		}
	}
}