class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i=0;i*k<=d;i++){
            long dist = (long)Math.sqrt(((long)d * d) - ((long)i*k * i*k));
            answer += dist / k + 1;
        }
        return answer;
    }
}