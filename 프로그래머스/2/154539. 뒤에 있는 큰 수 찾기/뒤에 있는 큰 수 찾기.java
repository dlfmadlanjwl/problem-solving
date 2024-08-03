class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int[] indexs = new int[numbers.length];
        
        answer[answer.length-1] = -1;
        for(int i=numbers.length-2;i>=0;i--){
            int idx = i+1;
            while(idx < numbers.length && idx != -1){
                if(numbers[i] < numbers[idx]){
                    answer[i] = numbers[idx];
                    indexs[i] = idx;
                    break;
                }else if(answer[idx] == -1){
                    answer[i] = -1;
                    break;
                }else{
                    idx = indexs[idx];
                }
            }
        }
        return answer;
    }
}