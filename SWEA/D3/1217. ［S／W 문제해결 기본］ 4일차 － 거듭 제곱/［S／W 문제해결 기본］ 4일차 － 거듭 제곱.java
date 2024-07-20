import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
				
		for(int test_case = 1; test_case <= 10; test_case++)
		{
        	int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            int result = pow(a, b, 1, a);
            
            System.out.println("#"+test_case+" "+result); 
        }
	}
    static int pow(int a, int b, int count, int result){
        if(b == count) return result;
        return pow(a, b, count+1, result*a);
    }
}