class Solution {
    public int[] solution(int n, long left, long right) {
        int[] result = new int[(int)right-(int)left+1];
        try{
            long startY = left / n;
        long startX = left % n;
        long endY = right / n;
        long endX = right % n;
        
        int idx = 0;
        for(long i=startX;i<n;i++){
            if(i<=startY){
                result[idx] = (int)startY+1;
            }
            else {
                result[idx] = (int)i+1;
            }
            idx++;
        }
        for(long i=startY+1;i<endY;i++){
            for(long j=0;j<n;j++){
                if(j<=i){
                    result[idx] = (int)i+1;
                }
                else {
                    result[idx] = (int)j+1;
                }
                idx++;
            }
        }
        for(long i=0;i<=endX;i++){
            if(i<=endY){
                result[idx] = (int)endY+1;
            }
            else {
                result[idx] = (int)i+1;
            }
            idx++;
        }
        } catch(Exception e){
            System.out.println(e);
        }
        
        return result;
    }
}
/*1 2 3 4 5
2 2 3 4 5
3 3 3 4 5
4 4 4 4 5
5 5 5 5 5*/
/*5 6 18*/

/* 1 2 3
   2 2 3
   3 3 3*/

/* 1 2 3 4
   2 2 3 4
   3 3 3 4
   4 4 4 4
*/
   
 