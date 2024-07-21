import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{	
            Stack<Character> stack = new Stack<>();
			int n = sc.nextInt();
            String input = sc.next();
            for(char c : input.toCharArray()){
                if(!stack.isEmpty()){
                	if(stack.peek() == c) {
                        stack.pop();
                    	continue;
                    }
                }
                stack.add(c);
            }
            String answer = "";
            while(!stack.isEmpty()){
            	answer = stack.pop() + answer;
            }
            System.out.println("#"+test_case+" "+answer);
		}
	}
}