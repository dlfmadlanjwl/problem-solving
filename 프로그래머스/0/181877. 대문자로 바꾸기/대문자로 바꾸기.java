class Solution {
    public String solution(String myString) {
        String answer = "";
        for(char c : myString.toCharArray()){
            if('A' <= c && 'Z' >= c) {
                answer += c;
            } else {
                answer += (char)(c + ('A' - 'a'));
            }
        }
        return answer;
    }
}