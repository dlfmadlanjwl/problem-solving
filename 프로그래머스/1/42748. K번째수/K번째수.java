import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            List<Integer> numbers = new ArrayList<>();
            for(int j=commands[i][0]-1;j<commands[i][1];j++){
                numbers.add(array[j]);
            }
            Collections.sort(numbers);
            result[i] = numbers.get(commands[i][2]-1);
        }
        return result;
    }
}