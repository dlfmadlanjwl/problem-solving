import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, num, min = Integer.MAX_VALUE;
    static int[] arr, list;
    static boolean[] check;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        N = s.length();
        num = Integer.parseInt(s);
        arr = new int[N];
        list = new int[N];
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(Character.toString(s.charAt(i)));
        }
        recursive(0);
        if(min==Integer.MAX_VALUE)System.out.print(0);
        else System.out.print(min);
    }
    static void recursive(int depth) {
        if (depth == N) {
            String s = "";
            for (int i : list) {
                s += i;
            }
            int n = Integer.parseInt(s);
            if (num < n) {
                min = Math.min(min, n);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                list[depth] = arr[i];
                recursive(depth + 1);
                check[i] = false;
            }
        }
    }
}
