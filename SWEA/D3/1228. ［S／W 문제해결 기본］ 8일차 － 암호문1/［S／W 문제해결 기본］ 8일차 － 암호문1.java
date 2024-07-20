import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
        	int a = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<a;i++){
            	int x = sc.nextInt();
                list.add(x);
            }
            int b = sc.nextInt();
            for(int i=0;i<b;i++){
            	sc.next();
                int idx = sc.nextInt();
                int n = sc.nextInt();
                for(int j=0;j<n;j++){
                	int x = sc.nextInt();
                    list.add(idx+j, x);
                }
            }
            System.out.print("#"+test_case+" ");
            for(int i=0;i<10;i++){
            	System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
	}
}