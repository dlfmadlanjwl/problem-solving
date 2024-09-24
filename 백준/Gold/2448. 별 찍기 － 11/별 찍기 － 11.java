import java.util.Arrays;
import java.util.Scanner;

public class Main{
    static char[][] star;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        star = new char[n][n/3*6];
        for(char[] arr : star){
            Arrays.fill(arr, ' ');
        }

        print(0,0, n-1, n/3*6-1);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<star.length;i++){
            for(int j=0;j<star[0].length;j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void print(int y1, int x1, int y2, int x2){
        if(y2 - y1 <= 2){
            star[y1][x1+2] = '*';
            star[y1+1][x1+1] = '*';
            star[y1+1][x1+3] = '*';
            for(int i=x1;i<x2;i++) star[y2][i] = '*';
        } else {
            print(y1, (x2 - x1 + 1) / 4 + x1, (y2 - y1 + 1) / 2 - 1 + y1, (x2 - x1 + 1) / 4 * 3 - 1 + x1);
            print((y2 - y1 + 1)/2 + y1, x1, y2, (x2 - x1 + 1) / 2 - 1 + x1);
            print((y2 - y1 + 1)/2 + y1, (x2 - x1 + 1) / 2 + x1, y2, x2);
        }
    }
}