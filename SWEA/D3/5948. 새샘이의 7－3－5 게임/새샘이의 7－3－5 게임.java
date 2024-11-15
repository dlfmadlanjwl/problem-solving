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
            int[] arr = new int[7];
			for(int i=0;i<7;i++){
            	arr[i] = sc.nextInt();
            }
            Set<Integer> set = new HashSet<>(dfs(arr, 0, 0, 0));
            List<Integer> list = new ArrayList<>();
            for(Integer num : set){
            	list.add(num);
            }
            Collections.sort(list, Collections.reverseOrder());
            System.out.println("#"+test_case+" "+list.get(4));
		}
	}
    
    static List<Integer> dfs(int[] arr, int start, int sum, int count){
        List<Integer> list = new ArrayList<>();
        if(count == 3){
        	list.add(sum);
            return list;
        }
    	for(int i=start;i<arr.length;i++){
        	list.addAll(dfs(arr, i+1, sum + arr[i], count+1));
        }
        return list;
    }
}