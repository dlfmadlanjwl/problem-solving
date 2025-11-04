import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[] electronics = new int[k];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            electronics[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        List<Integer> plugs = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (plugs.contains(electronics[i])) {
                continue;
            }
            if (plugs.size() == n) {
                List<Integer> futureUse = new ArrayList<>();
                for (int j = i + 1; j < k; j++) {
                    if (plugs.contains(electronics[j])) {
                        if (futureUse.contains(electronics[j])) {
                            continue;
                        }
                        futureUse.add(electronics[j]);
                    }
                }
                if (futureUse.size() != plugs.size()) {
                    for (int plug : plugs) {
                        if (!futureUse.contains(plug)) {
                            plugs.remove(Integer.valueOf(plug));
                            count++;
                            break;
                        }
                    }
                } else {
                    plugs.remove(futureUse.get(futureUse.size() - 1));
                    count++;
                }
            }
            plugs.add(electronics[i]);
        }

        System.out.println(count);
    }
}
