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
			String input = sc.next();
            int[] alphabet = new int[26];
            for(int i=0;i<input.length();i++){
            	if(alphabet[input.charAt(i) - 'a'] == 1){
                	alphabet[input.charAt(i) - 'a'] = 0;
                } else {
                	alphabet[input.charAt(i) - 'a'] = 1;
                }
            }
            System.out.print("#"+test_case+" ");
            boolean check = true;
            for(int i=0;i<26;i++){
            	if(alphabet[i] > 0) check = false;
            }
            if(check){
            	System.out.println("Good");
            } else {
            	 for(int i=0;i<26;i++){
            		if(alphabet[i] > 0) System.out.print((char)('a' + i));
            	}
            	System.out.println();
            }
		}
	}
}