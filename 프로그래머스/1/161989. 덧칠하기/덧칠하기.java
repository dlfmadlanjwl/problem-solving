class Solution {
    public int solution(int n, int m, int[] section) {
        int idx = 0;
        int answer = 0;
        int now = 1;
        while(now <= n){
            if(section[idx] == now){
                answer++;
                if(now + m > n)break;
                for(int i=now;i<now+m;i++){
                    if(idx == section.length) break;
                    if(section[idx] == i){
                        idx++;
                    }
                }
                if(idx>=section.length) break;
                now = now + m - 1;
            }
            now++;
        }
        return answer;
    }
}