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
            String[] words = new String[n];
            for(int i=0;i<n;i++){
            	words[i] = sc.next();
            }
            int answer = dfs(words, 0, new int[26]);
            System.out.println("#"+test_case+" "+answer);
		}
	}
    
    static int dfs(String[] words, int index, int[] alphabet){
    	if(index == words.length) {
            boolean check = true;
        	for(int i=0;i<alphabet.length;i++){
            	if(alphabet[i] <= 0){
                	check = false;
                }
            }
            if(check) return 1;
            return 0;
        }
        int sum = 0;
        String word = words[index];
        for(char c : word.toCharArray()){
        	alphabet[c-'a']++;
        }
        sum += dfs(words, index+1, alphabet);
        for(char c : word.toCharArray()){
        	alphabet[c-'a']--;
        }
        sum += dfs(words, index+1, alphabet);
        return sum;
    }
}