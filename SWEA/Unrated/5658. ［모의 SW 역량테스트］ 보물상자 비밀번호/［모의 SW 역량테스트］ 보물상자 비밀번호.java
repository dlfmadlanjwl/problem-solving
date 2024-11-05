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
            String input = sc.next();
            Set<String> set = new HashSet<>();
            for(int i=0;i<n/4;i++){
                for(int j=0;j<n;j+=n/4){
                    String str = input.substring(j, j+n/4);
                    set.add(str);
                }
                input = input.charAt(n - 1) + input.substring(0, n-1);
            }
            List<Integer> list = new ArrayList<>();

            for(String number : set){
                list.add(Integer.parseInt(number, 16));
            }
            list.sort(Collections.reverseOrder());

            System.out.println("#"+test_case+" "+list.get(k-1));
        }
    }
}