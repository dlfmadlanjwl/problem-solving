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
            char[] numbers = String.valueOf(n).toCharArray();
            boolean answer = dfs(numbers, "", new boolean[numbers.length], n);
            if(answer){
                System.out.println("#"+test_case+" possible");
            } else System.out.println("#"+test_case+" impossible");
        }
    }

    static boolean dfs(char[] numbers, String number, boolean[] isVisited, int n){
        if(numbers.length == number.length()){
            if(Integer.parseInt(number) % n == 0 && Integer.parseInt(number) > n) return true;
            return false;
        }
        boolean check = false;
        for(int i=0;i<numbers.length;i++) {
            if(isVisited[i]) continue;
            isVisited[i] = true;
            boolean result = dfs(numbers, number+numbers[i], isVisited, n);
            if(result){
                check = true;
            }
            isVisited[i] = false;
        }
        return check;
    }
}