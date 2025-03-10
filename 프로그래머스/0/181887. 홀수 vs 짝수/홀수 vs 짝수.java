class Solution {
    public int solution(int[] num_list) {
        int a = 0;
        int b = 0;
        for(int i=0;i<num_list.length;i++) {
            if(i % 2 == 0) b += num_list[i];
            if(i % 2 == 1) a += num_list[i];
        }
        
        return Math.max(a, b);
    }
}