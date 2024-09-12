import java.util.*;

class Solution
{
    static boolean[] isVisited;
    static int[] input;
    static int[] choices;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{	
            isVisited = new boolean[19];
            input = new int[9];
            for(int i=0;i<9;i++){
            	int x = sc.nextInt();
                input[i] = x;
                isVisited[x] = true;
            }
            
            choices = new int[9];
            int index = 0;
            for(int i=1;i<=18;i++){
            	if(!isVisited[i]) {
                    choices[index] = i;
                    index++;
                }
            }
            isVisited = new boolean[9];
            
            List<Integer> list = new ArrayList<>();
            int[] answer = dfs(list);
            System.out.println("#"+test_case+" "+answer[0]+" "+answer[1]);
		}
	}
    
    static int[] dfs(List<Integer> list){
        int[] count = new int[]{0, 0};
    	if(list.size() == 9){
            if(battle(list)) count[0]++;
            else count[1]++;
        	return count;
        }
        
        for(int i=0;i<9;i++){
        	if(isVisited[i]) continue;
           	list.add(choices[i]);
            isVisited[i] = true;
            int[] result = dfs(list);
            count[0] += result[0];
            count[1] += result[1];
            list.remove(list.size()-1);
            isVisited[i] = false;
        }
        
        return count;
    }
    
    static boolean battle(List<Integer> list){
        int aSum = 0;
        int bSum = 0;
    	for(int i=0;i<9;i++){
            int a = input[i];
            int b = list.get(i);
            
            if(a > b) aSum += a + b;
            else bSum += a + b;
        }
        
        return aSum > bSum;
    }
}