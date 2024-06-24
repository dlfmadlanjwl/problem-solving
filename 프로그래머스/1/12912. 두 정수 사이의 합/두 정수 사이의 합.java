class Solution {
    public long solution(int a, int b) {
        if(a == b) return a;
        
        long sum = 0;
        int bigNum = a > b ? a : b;
        int smallNum = a < b ? a : b;
        for(int i=smallNum;i<=bigNum;i++){
            sum += i;
        }
        return sum;
    }
}