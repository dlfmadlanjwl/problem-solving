import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);
        int size = 0;
        for(String op : operations){
            if(op.charAt(0) == 'I'){
                int x = Integer.parseInt(op.substring(2));
                pq1.add(x);
                pq2.add(x);
                size++;
            }else{
                if(size == 0) continue;
                if(Integer.parseInt(op.substring(2)) == 1){
                    pq2.poll();
                }else{
                    pq1.poll();
                }
                size--;
            }
        }

        List<Integer> list = pq1.stream().filter(pq2::contains).collect(Collectors.toList());
        Collections.sort(list);
        if(size == 0) return new int[]{0, 0};
        return new int[]{list.get(list.size()-1), list.get(0)};
    }
}