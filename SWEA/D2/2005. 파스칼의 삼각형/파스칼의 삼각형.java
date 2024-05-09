import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=0;t < T;t++){
            System.out.println("#"+(t+1));
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            arr[0][0] = 1;
            for(int i=1;i<N;i++){
                for(int j=0;j<N;j++){
                    if(j-1 < 0)arr[i][j] = arr[i-1][j];
                    else arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][j] == 0)continue;
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}