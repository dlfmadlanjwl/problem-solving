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
			Map<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<3;i++){
            	int input = sc.nextInt();
                map.put(input, map.getOrDefault(input, 0)+1);
            }
            
            int min = Integer.MAX_VALUE;
            int answer = 0;
            for(int key : map.keySet()){
            	if(map.get(key) < min){
                	min = map.get(key);
                    answer = key;
                }
            } 
            System.out.println("#"+test_case+" "+answer);
		}
	}
}