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
			int a = sc.nextInt();
            int b = sc.nextInt();
            int count = 0;
            for(int i=a;i<=b;i++){
                if(isPalindrom(i)){
                    int x = (int)Math.sqrt(i);
                    if(x*x == i && isPalindrom(x)) count++;
                }
            }
            System.out.println("#"+test_case+" "+count);
		}
	}
    
    static boolean isPalindrom(int x){
    	String s = String.valueOf(x);
        for(int i=0;i<s.length()/2;i++){
        	if(s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }
}