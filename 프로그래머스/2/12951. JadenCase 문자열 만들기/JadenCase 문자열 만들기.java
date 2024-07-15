class Solution {
    public String solution(String s) {
        String result = "";
        if(Character.isLowerCase(s.charAt(0))) result += (char)(s.charAt(0)+('A'-'a'));
        else result += s.charAt(0);
        
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
        
            if(s.charAt(i-1)==' ' && c!=' '){
                 if(Character.isLowerCase(c)) result += (char)(c+'A'-'a');    
                 else result += c;
            } else{
                if(Character.isUpperCase(c)) result += (char)(c-('A'-'a'));
                else result += c;
            }
        }
        return result;
    }
}