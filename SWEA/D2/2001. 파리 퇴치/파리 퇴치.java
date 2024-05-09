import java.util.Scanner;

public class Solution {
    private static int sum(int[][] arr, int m, int x, int y){
        int res = 0;
        for(int i=x;i<x+m;i++){
            for(int j=y;j<y+m;j++){
                res += arr[j][i];
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] arr = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int max = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i + M > N || j + M > N) continue;
                    int sum = sum(arr, M, j, i);
                    if(sum > max) max = sum;
                }
            }
            System.out.println("#"+(t+1)+" "+max);
        }
    }
}