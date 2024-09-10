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
            int k = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<n;i++){
            	list.add(sc.nextInt());
            }
            list.sort(Collections.reverseOrder());
            int sum = 0;
            for(int i=0;i<k;i++){
            	sum += list.get(i);
            }
            System.out.println("#"+test_case+" "+sum);
		}
	}
}