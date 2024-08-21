import java.util.Scanner;
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
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
            	arr[i] = sc.nextInt();
            }
            int max = -1;
            for(int i=1;i<n;i++){
            	for(int j=0;j<i;j++){
                	int a = arr[i], b = arr[j];
                    if(a * b > max){
                    	String str = String.valueOf(a * b);
                        boolean isValid = true;
                        for(int k=1;k<str.length();k++){
                        	if(str.charAt(k) < str.charAt(k-1)){
                                isValid = false;
                                break;
                            }
                        }
                        if(isValid) max = Integer.parseInt(str);
                    }
                }
            }
            System.out.println("#"+test_case+" "+max);
		}
	}
}