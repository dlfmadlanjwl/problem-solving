import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int startY = (int)(left / n);
        int startX = (int)(left % n);
        int endY = (int)(right / n);
        int endX = (int)(right % n);

        List<Integer> result = new ArrayList<>();

        if(startY != endY){
            for(int i=startX;i<n;i++){
                if(i<=startY){
                    result.add(startY+1);
                }
                else {
                    result.add(i+1);
                }
            }
            System.out.println();
            for(int i=startY+1;i<endY;i++){
                for(int j=0;j<n;j++){
                    if(j<=i){
                        result.add(i+1);
                    }
                    else {
                        result.add(j+1);
                    }
                }
            }
            for(int i=0;i<=endX;i++){
                if(i<=endY){
                    result.add(endY+1);
                }
                else {
                    result.add(i+1);
                }
            }
        }else{
            for(int i=startX;i<=endX;i++){
                if(i<=startY){
                    result.add(startY+1);
                }
                else {
                    result.add(i+1);
                }
            }
        }

        return result.stream().mapToInt(i->i).toArray();
    }
}