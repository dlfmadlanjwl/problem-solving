import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int now = q.peek();

            boolean isTop = true;
            for(int i=0;i<priorities.length;i++){
                if(priorities[i] > priorities[now] && q.contains(i)){
                    isTop = false;
                }
            }
            if(!isTop){
                q.add(q.poll());
            } else{
                count++;
                int n = q.poll();
                if(n == location) return count;
            }
        }
        return count;
    }
}