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
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for(int i=0;i<n;i++){
            	int score = sc.nextInt();
                List<Integer> list = new ArrayList<>();
                for(int sum : set){
                	list.add(sum + score);
                }
                set.addAll(list);
            }
            System.out.println("#"+test_case+" "+set.size());
		}
	}
}