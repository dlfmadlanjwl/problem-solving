import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Long, Integer> map = new HashMap<>();

        int max = 0;
        long result = 0;
        for (int i = 0; i < N; i++) {
            long tmp = Long.parseLong(br.readLine());

            map.put(tmp, map.getOrDefault(tmp, 0) + 1);

            if (map.get(tmp) > max) {
                max = map.get(tmp);
                result = tmp;
            } else if (map.get(tmp) == max) {
                result = Math.min(result, tmp);
            }
        }
        System.out.println(result);
    }
}