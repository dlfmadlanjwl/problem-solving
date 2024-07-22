import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()) stack.add(c);
            else{
                if(stack.peek() == c) stack.pop();
                else stack.add(c);
            }
        }
        if(stack.isEmpty()) return 1;
        return 0;
    }
}