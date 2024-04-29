import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(c==')'){
                if(stack.isEmpty()) return false;
                if(stack.peek()=='('){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.add(c);
            }
        }

        return stack.isEmpty();
    }
}