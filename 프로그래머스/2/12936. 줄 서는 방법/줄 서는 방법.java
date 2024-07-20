import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        long total = 1;
        for(int i=2;i<=n;i++){
            total *= i;
        }
        long div = total / n;
        int idx = n;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            int x = (int)((k-1) / div);
            k -= x * div;
            result[i] = list.get(x);
            list.remove(x);
            if(list.size()==0) break;
            idx--;
            div /= idx;
        } 
        
        return result;
    }
}