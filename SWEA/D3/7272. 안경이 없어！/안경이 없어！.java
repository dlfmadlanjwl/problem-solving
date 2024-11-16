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
			int[] arr = new int[26];
            String noHole = "CEFGHIJKLMNSTUVWXYZ";
            String oneHole = "ADOPQR";
            for(int i=0;i<noHole.length();i++){
            	arr[noHole.charAt(i) - 'A'] = 1;
            }
            for(int i=0;i<oneHole.length();i++){
            	arr[oneHole.charAt(i) - 'A'] = 2;
            }
            arr['B' - 'A'] = 3;
            
            String a = sc.next();
            String b = sc.next();
            System.out.print("#"+test_case+" ");
            if(a.length() != b.length()){
            	System.out.println("DIFF");
                continue;
            }
            boolean same = true;
            for(int i=0;i<a.length();i++){
            	if(arr[a.charAt(i) - 'A'] != arr[b.charAt(i) - 'A']) same = false;
            }
            if(same) System.out.println("SAME");
            else System.out.println("DIFF");
		}
	}
}