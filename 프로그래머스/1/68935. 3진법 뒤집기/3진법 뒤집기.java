class Solution {
    public int solution(int n) {
        String str = Integer.toString(n,3);
        
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();
        
        return Integer.valueOf(str,3);
    }
}