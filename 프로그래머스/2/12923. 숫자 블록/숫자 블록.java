class Solution {
    public int[] solution(long begin, long end) {
        int[] dp = new int[(int)(end-begin+1)];
        for(long i=begin;i<=end;i++){
            int max = 0;
            for(long j=1;j<=Math.sqrt(i);j++){
                if(i % j == 0 && i / j != 1){
                    if(j == 1) max = 1;
                    else{
                        if(j > max && j <= 10000000) max = (int)j;
                        if(i/j > max && i/j <= 10000000) max = (int)(i/j);
                    } 
                }
                dp[(int)(i-begin)] = max;
            }
        }
            
        return dp;
    }
}

