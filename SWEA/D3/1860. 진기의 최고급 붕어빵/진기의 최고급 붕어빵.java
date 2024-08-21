import java.util.*;
import java.io.FileInputStream;

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
            int[] guest = new int[n];
            int m = sc.nextInt();
            int k = sc.nextInt();
            for(int i=0;i<n;i++){
            	guest[i] = sc.nextInt();
            }
            Arrays.sort(guest);
            
            int guestIdx = 0;
            int bread = 0;
            boolean isPossible = true;
            for(int i=0;i<=guest[guest.length-1];i++){
            	if(i!=0 && i % m == 0) bread += k;
                while(guestIdx < n && guest[guestIdx] == i){
                	bread--;
                    guestIdx++;
                }
                if(bread < 0) {
                	isPossible = false;
                    break;
                }
            }
            System.out.print("#"+test_case+" ");
            if(isPossible) System.out.println("Possible");
            else System.out.println("Impossible");
		}
	}
}