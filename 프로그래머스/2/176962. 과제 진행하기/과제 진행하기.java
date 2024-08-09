import java.util.*;

class Solution {
    public String[] solution(String[][] input) {
        int[][] plans = new int[input.length][3];
        for(int i=0;i<input.length;i++){
            int hour = Integer.parseInt(input[i][1].split(":")[0]);
            int minute = Integer.parseInt(input[i][1].split(":")[1]);
            plans[i][0] = i;
            plans[i][1] = hour * 60 + minute;
            plans[i][2] = Integer.parseInt(input[i][2]);
        }
        Arrays.sort(plans, new Comparator<>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        Stack<Todo> todoList = new Stack<>();
        List<Integer> doneList = new ArrayList<>();
        
        int time = plans[0][1];
        for(int i=1;i<plans.length;i++){
            int[] plan = plans[i];
            int spareTime = plan[1] - (time + plans[i-1][2]);
            if(spareTime >= 0){
                doneList.add(plans[i-1][0]);
                while(spareTime != 0 && !todoList.isEmpty()){
                    if(todoList.peek().leftTime <= spareTime){
                        spareTime -= todoList.peek().leftTime;
                        doneList.add(todoList.pop().num);
                    }else{
                        todoList.peek().leftTime -= spareTime;
                        spareTime = 0;
                    }
                }
            }else{
                todoList.add(new Todo(plans[i-1][0], plans[i-1][2]-(plan[1]-time)));
            }
            time = plan[1];
        }
        
        doneList.add(plans[plans.length-1][0]);
        while(!todoList.isEmpty()){
            doneList.add(todoList.pop().num);
        }
        
        String[] answer = new String[doneList.size()];
        for(int i=0;i<doneList.size();i++){
            answer[i] = input[doneList.get(i)][0];
        }
        return answer;
    }
    
    class Todo{
        int num;
        int leftTime;
        
        Todo(int num, int leftTime){
            this.num = num;
            this.leftTime = leftTime;
        }
    }
}