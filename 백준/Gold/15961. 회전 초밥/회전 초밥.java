import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int d = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        int[] counts = new int[d + 1];

        List<Integer> sushis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sushis.add(Integer.parseInt(bufferedReader.readLine()));
        }
        Set<Integer> sushiType = new HashSet<>();
        for (int i = sushis.size() - 1; i >= sushis.size() - k; i--) {
            int sush = sushis.get(i);
            counts[sush]++;
            sushiType.add(sush);
        }
        counts[c]++;
        sushiType.add(c);
        long answer = sushiType.size();
        int start = sushis.size() - k - 1;
        int tail = sushis.size() - 1;
        while (start != sushis.size() - k) {
            counts[sushis.get(start)]++;
            sushiType.add(sushis.get(start));
            counts[sushis.get(tail)]--;
            if (counts[sushis.get(tail)] == 0) {
                sushiType.remove(sushis.get(tail));
            }
            answer = Math.max(answer, sushiType.size());
            start--;
            tail--;
            if (start == -1) {
                start = sushis.size() - 1;
            }
            if (tail == -1) {
                tail = sushis.size() - 1;
            }
        }
        System.out.println(answer);
    }
}