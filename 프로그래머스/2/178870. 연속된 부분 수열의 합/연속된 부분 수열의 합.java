import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        List<int[]> list = new ArrayList<>();
        int end = 0;
        int sum = 0;
        for(int i=0;i<sequence.length;i++){
            while(sum < k && end < sequence.length){
                sum += sequence[end];
                end++;
            }

            if(sum == k){
                int[] arr = {i, end-1};
                list.add(arr);
            }

            sum -= sequence[i];
        }

        list.sort(new Comparator<>(){
            public int compare(int[] a, int[] b){
                return (a[1] - a[0]) - (b[1] - b[0]);
            }
        });

        return list.get(0);
    }
}