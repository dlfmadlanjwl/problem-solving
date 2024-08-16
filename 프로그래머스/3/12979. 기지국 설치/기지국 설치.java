class Solution {
    public int solution(int n, int[] stations, int w) {        
        int answer = 0;
        int range = w*2+1;
        int idx = 1;
        for(int station : stations){
            int dist = station - w - idx;
            answer += (int)(Math.ceil((double)dist / range));
            idx = station + w + 1;
        }
        answer += (int)Math.ceil((double)(n-idx+1) / range);

        return answer;
    }
}