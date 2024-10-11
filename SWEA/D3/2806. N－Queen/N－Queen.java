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

            int[] chess = new int[n];
            Arrays.fill(chess, -1);
            int answer = dfs(chess, 0);
            System.out.println("#"+test_case+" "+answer);
        }
    }

    static int dfs(int[] chess, int idx){
        if(idx == chess.length) return 1;
        int count = 0;
        for(int i=0;i<chess.length;i++){
            boolean possible = true;
            for(int j=0;j<idx;j++){
                if(chess[j] == i) possible = false;
                if(Math.abs(idx - j) == Math.abs(i - chess[j])) possible = false;
            }
            if(possible){
                chess[idx] = i;
                count += dfs(chess, idx+1);
                chess[idx] = -1;
            }
        }

        return count;
    }
}