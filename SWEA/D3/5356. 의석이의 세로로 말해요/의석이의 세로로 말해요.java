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
            String[] arr = new String[5];
            int maxLen = 0;
			for(int i=0;i<5;i++){
            	arr[i] = sc.next();
                maxLen = Math.max(maxLen, arr[i].length());
            }
            System.out.print("#"+test_case+" ");
            for(int i=0;i<maxLen;i++){
            	for(int j=0;j<5;j++){
                	if(arr[j].length()-1 < i) continue;
                    System.out.print(arr[j].charAt(i));
                }
            }
            System.out.println();
		}
	}
}