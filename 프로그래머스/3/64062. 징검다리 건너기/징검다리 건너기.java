import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int max = Arrays.stream(stones).max().getAsInt();
        return binarySearch(stones, k, max);
    }
    
    int binarySearch(int[] stones, int k, int max){
        int left = 0, right = max;
        while(left < right){
            int mid = (left + right) / 2;
            int count = 0;
            boolean onRight = true;
            for(int stone : stones){
                if(stone - mid <= 0) count++;
                else count = 0;
                if(count >= k){
                    onRight = false;
                    break;
                }
            }
            if(onRight){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
