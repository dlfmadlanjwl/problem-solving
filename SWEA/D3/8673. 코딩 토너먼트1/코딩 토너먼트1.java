import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int k =sc.nextInt();
            int n = (int)Math.pow(2,k);
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
            	arr[i] = sc.nextInt();
            }
            
            int sum = 0;
            for(int i=n;i>0;i/=2){
            	int[] nextArr = new int[i/2];
                for(int j=0;j<i/2;j++){
                	nextArr[j] = Math.max(arr[j*2], arr[j*2+1]);
                    sum += Math.abs(arr[j*2] - arr[j*2+1]);
                }
                
                arr = nextArr;
            }
            System.out.println("#"+test_case+" "+sum);
		}
	}
}