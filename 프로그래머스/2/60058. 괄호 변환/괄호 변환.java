import java.util.*;

class Solution {
    public String solution(String p) {
        return dfs(p);
    }
    
    private String dfs(String p){
        if(p.isEmpty()) return p;
        
        String[] arr = separateString(p);
        
        if(isCorrect(arr[0])){
            return arr[0] + dfs(arr[1]);
        }else{
            return '(' + dfs(arr[1]) + ')' + convertString(arr[0]);
        }
    }
    
    private String[] separateString(String p){
        int left = 0;
        int right = 0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(') left++;
            else right++;
            
            if(left == right) 
                return new String[]{p.substring(0,i+1),p.substring(i+1)};
        }
        return new String[]{p, ""};
    } 
    
    private boolean isCorrect(String p){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<p.length();i++){
            char now = p.charAt(i);
            if(stack.isEmpty()){
                stack.add(now);
                continue;
            }
            if(stack.peek()=='(' && now == ')') stack.pop();
            else stack.add(now);
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
    
    private String convertString(String p){
        String str = p.substring(1);
        str = str.substring(0, str.length()-1);
        System.out.println(str);
        String res = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('){
                res += ')';
            }else res += '(';
        }
        return res;
    }
}         
    
