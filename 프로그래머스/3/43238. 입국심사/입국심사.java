class Solution {
    public long solution(int n, int[] times) {
        long start = 0;
        long end = 1000000000000000000L;
        while(start<end){
            long t = (start+end)/2;
            if(isValid(times, n, t)){
                end = t;
            }else{
                start = t+1;
            }
        }
        
        return start;
    }

    private boolean isValid(int[] times, int n, long time){
        long sum = 0;
        for(int t:times){
            sum += time/t;
        }
        return sum>=n;
    }
}