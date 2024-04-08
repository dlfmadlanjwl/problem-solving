import java.util.Arrays;

class Solution {
    public int solution(int[][] dots) {
        int cnt = 0;
        for(int i=0;i<4;i++){
            for(int j=i;j<4;j++){
                int[] dot1 = dots[i];
                int[] dot2 = dots[j];
                int a = i;
                int b = j;
                int[] arr = Arrays.stream(new int[]{0,1,2,3}).filter(x->x!=a && x!=b).toArray();

                float res1 = calculate(dots, a,b);
                float res2 = calculate(dots, arr[0], arr[1]);

                if(res1==0 || res2==0)continue;;

                if(res1==res2) {
                    cnt++;
                }
            }
        }
        if(cnt>0) return 1;
        return 0;
    }

    float calculate(int[][] dots, int a, int b){
        int[] dot1 = dots[a];
        int[] dot2 = dots[b];

        if(dot2[0] - dot1[0]==0 || dot2[1]-dot1[1]==0) return 0;

        return ((float) dot2[1]-dot1[1])/((float) dot2[0] - dot1[0]);
    }
}