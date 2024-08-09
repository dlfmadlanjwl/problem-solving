import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        List<Integer> q = new ArrayList<>();
        for(int i=0;i<queue1.length;i++){
            q.add(queue1[i]);
        }
        for(int i=0;i<queue2.length;i++){
            q.add(queue2[i]);
        }

        long target = 0;
        for(int i=0;i<q.size();i++){
            target += q.get(i);
        }
        target /= 2;

        int left = 0;
        int right = queue1.length-1;
        long curr = 0;
        for(int i=0;i<queue1.length;i++){
            curr += queue1[i];
        }
        
        int count = 0;
        while (left < q.size() && right < q.size()){
            if (curr == target){
                return count;
            }else if (curr < target && right < q.size()-1){
                right += 1;
                curr += q.get(right);
            } else {
                curr -= q.get(left);
                left += 1;
            }
            count += 1;
        }

        return -1;
    }
}