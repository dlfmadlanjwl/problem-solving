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
			List<Integer> list = new ArrayList<>();
            int k = sc.nextInt();
            for(int i=0;i<k;i++){
                int x = sc.nextInt();
            	if(x == 0) list.remove(list.size()-1);
                else list.add(x);
            }
            int sum = 0;
            for(int i=0;i<list.size();i++){
            	sum += list.get(i);
            }
            System.out.println("#"+test_case+" "+sum);
		}
	}
}