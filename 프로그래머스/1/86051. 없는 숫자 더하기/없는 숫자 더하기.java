class Solution {
    public int solution(int[] numbers) {
        boolean[] isVisited = new boolean[10];
        for(int i:numbers){
            isVisited[i] = true;
        }
        int answer = 0;
        for(int i=0;i < 10;i++){
            if(!isVisited[i]){
                answer += i;
            }
        }
        return answer;
    }
}