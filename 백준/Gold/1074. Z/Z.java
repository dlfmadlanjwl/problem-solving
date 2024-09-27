import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int r, c;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int l = (int)Math.pow(2, n);

        recursion(0, 0, l);

        System.out.print(answer);
    }

    static void recursion(int y, int x, int size){
        if(size == 1) return;
        if(r < y + size/2 && c < x + size/2){
            recursion(y, x, size/2);
        } else if(r < y + size/2 && c >= x + size/2){
            answer += (int)Math.pow(size/2, 2);
            recursion(y, x + size/2, size/2);
        } else if(r >= y + size/2 && c < x + size/2){
            answer += (int)Math.pow(size/2, 2) * 2;
            recursion(y + size/2, x, size/2);
        } else {
            answer += (int)Math.pow(size/2, 2) * 3;
            recursion(y + size/2, x + size/2, size/2);
        }
    }
}