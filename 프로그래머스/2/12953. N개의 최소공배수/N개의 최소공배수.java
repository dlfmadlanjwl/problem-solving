class Solution {
    public int solution(int[] arr) {
        int max = 0;
        long mul = 1;
        for(int i=0;i<arr.length;i++){
            mul *= arr[i];
            if(arr[i] > max) max = arr[i];
        }
        
        int answer = 0;
        for(int i=max; i<=mul;i++){
            boolean isValid = true;
            for(int j=0;j<arr.length;j++){
                if(i % arr[j] != 0) isValid = false;
            }
            if(isValid) return i;
            
        }
        return 0;
    }
}