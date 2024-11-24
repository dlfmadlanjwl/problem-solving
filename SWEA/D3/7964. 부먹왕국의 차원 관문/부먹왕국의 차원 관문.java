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
            int d = sc.nextInt();

            int[] city = new int[n+2];
            for(int i=1;i<=n;i++) {
                city[i] = sc.nextInt();
            }

            city[0] = 1;
            city[n+1] = 1;

            int count = 0;
            for(int i=1;i<=n;i++){
                if(city[i] == 1) continue;
                boolean need = true;
                for(int j=i-1;j>=i-(d-1);j--){
                    if(j < 0) break;
                    if(city[j] == 1){
                        need = false;
                    }
                }
                if(need){
                    count++;
                    city[i] = 1;
                }
            }

            System.out.println("#"+test_case+" "+count);
        }
    }
}