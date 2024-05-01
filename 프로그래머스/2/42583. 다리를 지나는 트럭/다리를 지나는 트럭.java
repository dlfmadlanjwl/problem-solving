import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static class Truck{
        int weight;
        int second;

        Truck(int weight){
            this.weight = weight;
            this.second = 1;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int second = -1;

        Queue<Truck> queue = new LinkedList<>();

        int total_weight = 0;
        int index = 0;
        while(true){
            second++;
            queue.forEach(x->x.second++);

            while(!queue.isEmpty()) {
                if(queue.peek().second > bridge_length){
                    Truck truck = queue.poll();
                    total_weight -= truck.weight;
                } else break;
            }

            if(index < truck_weights.length){
                if(total_weight + truck_weights[index] <= weight){
                    Truck truck = new Truck(truck_weights[index]);
                    queue.add(truck);
                    total_weight += truck.weight;
                    index++;
                }
            }

            if(queue.isEmpty()) break;
        }

        return second+1;
    }
}