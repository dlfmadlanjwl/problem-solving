import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            sc.nextInt();
			int[] arr = new int[8];
            for(int i=0;i<8;i++){
            	arr[i] = sc.nextInt();
            }
            
            int idx = 0;
            int x = 1;
            while(true){
            	if(x > 5) x = 1;
                if(idx > 7) idx = 0;
                arr[idx] -= x;
                if(arr[idx] <= 0){
                    arr[idx] = 0;
                	break;
                }
                idx++;
                x++;
            }
            System.out.print("#"+test_case+" "); 
            for(int i=idx+1;i<arr.length;i++){
            	System.out.print(arr[i]+" ");
            }
            for(int i=0;i<=idx;i++){
            	System.out.print(arr[i]+" ");
            }
            System.out.println();
		}
	}
}