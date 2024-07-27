import java.util.*;

class Solution {
    Set<Integer> set;
    public int solution(int[] elements) {
        set = new HashSet<>();
        int[] arr = new int[elements.length*2];
        for(int i=0;i<elements.length;i++){
            arr[i] = elements[i];
        }
        for(int i=0;i<elements.length;i++){
            arr[i+elements.length] = elements[i];
        }
        for(int i=1;i<=elements.length;i++){
            dfs(arr, -1, 0, i);
        }
        return set.size();
    }
    
    void dfs(int[] arr, int startIndex, int index, int k){
        if(startIndex > -1){
            if(index - startIndex == k){
                int sum = 0;
                for(int i=startIndex;i<index;i++){
                    sum += arr[i];
                }
                set.add(sum);
                return;
            }else{
                if(index != arr.length-1) dfs(arr, startIndex, index+1, k);
            }
        }else{
            if(index != arr.length - 1){
                dfs(arr, index, index+1, k);
                dfs(arr, startIndex, index+1, k);   
            }
        }
    }
}