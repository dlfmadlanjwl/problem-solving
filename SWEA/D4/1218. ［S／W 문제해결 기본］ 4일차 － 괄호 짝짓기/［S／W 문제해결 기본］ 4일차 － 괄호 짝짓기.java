import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
            String input = sc.next();
            Stack<Character> stack = new Stack<>();
            boolean possible = true;
            for(char c : input.toCharArray()){
            	if(c == '(' || c == '[' || c == '{' || c == '<'){
                	stack.push(c);
                } else if(c == ')'){
                	if(stack.peek() == '(') stack.pop();
                    else {
                    	possible = false;
                        break;
                    }
                } else if(c == '}'){
                	if(stack.peek() == '{') stack.pop();
                    else {
                    	possible = false;
                        break;
                    }
                } else if(c == '>'){
                	if(stack.peek() == '<') stack.pop();
                    else {
                    	possible = false;
                        break;
                    }
                } else if(c == ']'){
                	if(stack.peek() == '[') stack.pop();
                    else {
                    	possible = false;
                        break;
                    }
                }
            }
            System.out.print("#"+test_case+" ");
            if(possible) System.out.println(1);
            else System.out.println(0);
		}
	}
}