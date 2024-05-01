import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>(Arrays.stream(progresses).boxed().collect(Collectors.toList()));
        List<Integer> answer = new ArrayList<>();

        int day = 0;
        int index = 0;
        while(true){
            day++;
            int count = 0;
            while(queue.peek()+speeds[index]*day>=100){
                count++;
                queue.poll();
                index++;
                if(queue.isEmpty()) break;
            }
            if(count!=0) answer.add(count);
            if(queue.isEmpty()) break;
        }

        int[] result = new int[answer.size()];
        for(int i=0;i<result.length;i++){
            result[i] = answer.get(i);
        }

        return result;
    }
}