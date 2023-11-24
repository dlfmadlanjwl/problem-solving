import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] res = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        res[N] = -1;
        for(int i=N-1;i>0;i--){
            if(arr[i]==arr[i+1]){
                res[i] = res[i+1];
            }
            else {
                res[i] = i+1;
            }
        }
        for(int i=1;i<=N;i++){
            sb.append(res[i]+" ");
        }
        System.out.print(sb);
    }
}
