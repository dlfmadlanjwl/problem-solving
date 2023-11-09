import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        input[0] = Integer.parseInt(st.nextToken());
        int increase = 1;
        int decrease = 1;
        int max = 1;
        for(int i=1;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
            if(input[i-1]<input[i]){
                increase++;
                decrease = 1;
            } else if(input[i-1]>input[i]){
                decrease++;
                increase = 1;
            }else{
                increase++;
                decrease++;
            }
            if(increase>max){
                max = increase;
            } else if (decrease>max) {
                max = decrease;
            }
        }
        System.out.print(max);
    }
}