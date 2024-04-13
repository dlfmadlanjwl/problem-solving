class Solution {
    int result = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return result;
    }

    void dfs(int[] numbers, int index, int num, int target){
        if(index == numbers.length) {
            if(num == target) result++;
            return;
        }

        dfs(numbers, index+1, num+numbers[index], target);
        dfs(numbers, index+1, num-numbers[index], target);
    }
}