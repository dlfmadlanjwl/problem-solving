import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static char[] str;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        String input;
        while ((input = br.readLine())!=null){
            n = Integer.parseInt(input);
            int N = (int)Math.pow(3,n);
            str = new char[N];
            for(int i=0;i<N;i++){
                str[i] = '-';
            }
            recursive(0,N-1,0);
            sb = new StringBuilder();
            for(int i=0;i<N;i++){
                sb.append(str[i]);
            }
            System.out.println(sb);
        }
    }
    static void recursive(int start,int end,int depth){
        if(depth == n)return;

        int left = start+(end-start+1)/3;
        int right = left+(end-start+1)/3-1;
        for(int i=left;i<=right;i++){
            str[i] = ' ';
        }
        recursive(start,left-1,depth+1);
        recursive(right+1,end,depth+1);
    }
}