import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        String[] numbers = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		for(int test_case = 1; test_case <= T; test_case++)
		{
        	sc.next();
            int n = sc.nextInt();
            Map<String, Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
            	String input = sc.next();
                map.put(input, map.getOrDefault(input, 0)+1);
            }
            System.out.println("#"+test_case);
            for(int i=0;i<10;i++){
                int count = map.get(numbers[i]);
            	for(int j=0; j<count; j++) System.out.print(numbers[i]+" ");
            }
        }
	}
}