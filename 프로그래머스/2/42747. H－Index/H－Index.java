import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for(int i=citations.length;i>0;i--){
            if(citations[citations.length-i]>=i) return i;
        }
        return 0;
    }
}