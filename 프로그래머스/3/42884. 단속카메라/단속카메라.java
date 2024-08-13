import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        int count = 1;
        for(int[] route : routes){
            if((route[0] >= left && route[0] <= right) ||
              (route[1] <= right && route[1] >= left)){
                left = Math.max(route[0], left);
                right = Math.min(route[1], right);
            } else {
                left = route[0];
                right = route[1];
                count++;
            }
        }
        
        return count;
    }
}