class Solution {
    public String solution(String s) {
        String[] inputs = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(String input : inputs){
            int x = Integer.parseInt(input);
            if(x > max) max = x;
            if(x < min) min = x;
        }
        
        return min + " " + max;
    }
}