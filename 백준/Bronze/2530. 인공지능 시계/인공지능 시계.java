import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());

        second = second + N;
        minute = minute + second / 60;
        second = second % 60;
        hour = hour + (minute / 60);
        minute = minute % 60;
        hour = hour % 24;

        System.out.print(hour + " " + minute + " " + second);
    }
}



