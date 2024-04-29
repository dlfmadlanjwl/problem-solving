import java.util.Stack;

class Solution {
    public int solution(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(isCorrect(rotateString(s, i))) count++;
        }

        return count;
    }

    private String rotateString(String s, int offset){
        return s.substring(offset) + s.substring(0,offset);
    }

    private boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.add(c);
            }else if(stack.isEmpty()){
                return false;
            }else if(c == ')' && stack.peek() == '('){
                stack.pop();
            }else if(c == ']' && stack.peek() == '['){
                stack.pop();
            }else if(c == '}' && stack.peek() == '{'){
                stack.pop();
            }else return false;
        }
        return stack.isEmpty();
    }
}