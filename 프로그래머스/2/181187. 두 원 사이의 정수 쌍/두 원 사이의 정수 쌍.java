class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(int x=1;x<=r2;x++){
            int y1 = (int)Math.sqrt((long)r2*r2 - (long)x*x);
            int y2 = (int)Math.ceil(Math.sqrt((long)r1*r1 - (long)x*x));

            if(x > r1) answer += (y1+1) * 4;
            else answer += (y1 - y2 + 1) * 4;
        }
        return answer;
    }
}