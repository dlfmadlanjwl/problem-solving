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
            Stack<Character> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            for(char c : input.toCharArray()){
                if(c == '(' || c == '*' || c == '+') stack1.add(c);
                if(c >= '0' && c <= '9') {
                    if(stack1.peek() == '*'){
                        stack1.pop();
                        int top = stack2.pop();
                        stack2.add(top * (int)(c - '0'));
                    } else if(stack1.peek() == '+'){
                        stack2.add((int)(c - '0'));
                    } else stack2.add(c - '0');
                }
                if(c == ')'){
                    while(true){
                        if(stack1.peek() == '+'){
                            stack1.pop();
                            stack2.add(stack2.pop() + stack2.pop());
                        } else if(stack1.peek() == '('){
                            stack1.pop();
                            if(!stack1.isEmpty() && stack1.peek() == '*'){
                                stack1.pop();
                                stack2.add(stack2.pop() * stack2.pop());
                            }
                            break;
                        }
                    }
                }
            }
            int answer = 0;
            while(!stack2.isEmpty()){
                answer += stack2.pop();
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}