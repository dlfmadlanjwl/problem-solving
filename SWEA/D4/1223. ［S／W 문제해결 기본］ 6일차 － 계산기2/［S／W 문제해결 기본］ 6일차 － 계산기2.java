import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int len = sc.nextInt();
            String input = sc.next();
            String post = changeToPost(input);
            System.out.println("#"+test_case+" "+cal(post));
		}
	}
    
    static int cal(String input){
        Stack<Integer> stack = new Stack<>();
    	for(char c : input.toCharArray()){
        	if('0' <= c && c <= '9'){
            	stack.add(c - '0');
            } else if(c == '+'){
            	stack.add(stack.pop() + stack.pop());
            } else {
            		stack.add(stack.pop() * stack.pop());
            }
        }
        return stack.pop();
    }
    
    static String changeToPost(String input){
        String post = "";
        Stack<Character> stack = new Stack<>();
    	for(char c : input.toCharArray()){
        	if('0' <= c && c <= '9') post += c;
            else if (c =='*'){
            	if(stack.isEmpty()) stack.add(c);
                else if(stack.peek() == '*') {
                	post += c;
                } else {
                	stack.add(c);
                }
            } else if(c=='+'){
            	if(stack.isEmpty()) stack.add(c);
                else {
                    post += stack.pop();
                	stack.add(c);
                }
            }
        }
        while(!stack.isEmpty()){
        	post += stack.pop();
        }
        return post;
    }
}