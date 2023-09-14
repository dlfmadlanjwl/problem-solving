import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            int tmp;
            for(int j=0;j<=(b-a)/2;j++){
                tmp = arr[a+j];
                arr[a+j] = arr[b-j];
                arr[b-j] = tmp;
            }
        }
        for(int j=0;j<n;j++){
            System.out.print(arr[j]+" ");
        }
    }
}