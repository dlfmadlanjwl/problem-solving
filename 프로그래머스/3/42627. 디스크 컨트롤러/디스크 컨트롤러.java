import java.util.*;

import static java.lang.Thread.sleep;

class Solution {
    class Task{
        int requestTime;
        int jobTime;
        Task(int requestTime, int jobTime){
            this.requestTime = requestTime;
            this.jobTime = jobTime;
        }
    }
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Task a, Task b){
                return a.jobTime - b.jobTime;
            }
        });
        Task now = null;
        int index = 0;
        int time = 0;
        int count = jobs.length;
        List<Integer> list = new ArrayList<>();
        while(count > 0){
            while(index < jobs.length && jobs[index][0] == time){
                pq.add(new Task(jobs[index][0], jobs[index][1]));
                index++;
            }
            if(now != null){
                now.jobTime--;
                if(now.jobTime == 0){
                    list.add(time-now.requestTime);
                    now = null;
                    count--;
                }
            }

            if(now == null){
                if(!pq.isEmpty()) now = pq.poll();
            }

            time++;
        }

        return (int)list.stream().mapToInt(i->i).average().getAsDouble();
    }
}