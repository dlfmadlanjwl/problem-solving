import java.util.*;
import java.lang.Math;
class Solution {
    public boolean dividing(int[] arr, int num){
        for(int n : arr){
            if(n%num == 0) continue;
            else return false;
        }

        return true;
    }

    public boolean notDividing(int[] arr, int num){
        for(int n : arr){
            if(n%num != 0) continue;
            else return false;
        }

        return true;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int num = Math.max(arrayA[0], arrayB[0]);
        for(int i=2; i<=num; i++){
            if((dividing(arrayA, i) && notDividing(arrayB,i)) || 
              (dividing(arrayB, i) && notDividing(arrayA,i))){
                answer = i;
            }
        }
        return answer;
    }
}
