import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        
        Stack<Integer> assistance = new Stack<>();
        int i = 0;
        
        for(int box = 1; box <= order.length; box++){
            if(order[i] != box){
                assistance.add(box);
                continue;
            }

            i++;
            while(assistance.size() != 0 && order[i] == assistance.peek()){
                assistance.pop();
                i++;
            }
        }

        return i;
    }
}