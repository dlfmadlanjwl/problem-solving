import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            int max = -1, min = 10001;
            int total = 0;
            for(int i=0;i<10;i++){
                int x = sc.nextInt();
                if(x > max) max = x;
                if(x < min) min = x;
                total += x;
            }

            int answer = Math.round((float)(total - max - min) / 8);
            System.out.println("#"+(t+1)+" "+answer);
        }
    }
}