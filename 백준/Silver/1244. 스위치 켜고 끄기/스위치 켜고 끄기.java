import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<SwitchStatus> switchStatuses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                switchStatuses.add(SwitchStatus.ON);
                continue;
            }
            switchStatuses.add(SwitchStatus.OFF);
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String sex = st.nextToken();
            if (sex.equals("1")) {
                processMan(switchStatuses, Integer.parseInt(st.nextToken()));
                continue;
            }
            processWoman(switchStatuses, Integer.parseInt(st.nextToken()) - 1);
        }

        for (int i = 0; i < switchStatuses.size(); i++) {
            if (i % 20 == 0 && i / 20 > 0) {
                System.out.println();
            }
            System.out.print(switchStatuses.get(i).getNumber() + " ");
        }
    }

    private static void processMan(List<SwitchStatus> statuses, int number) {
        for (int i = 1; i <= statuses.size(); i++) {
            if (i % number == 0 && i / number > 0) {
                statuses.set(i - 1, statuses.get(i - 1).reverse());
            }
        }
    }

    private static void processWoman(List<SwitchStatus> statuses, int startNumber) {
        int left = startNumber - 1;
        int right = startNumber + 1;
        statuses.set(startNumber, statuses.get(startNumber).reverse());
        while (left >= 0 && right < statuses.size()) {
            if (statuses.get(left) == statuses.get(right)) {
                statuses.set(left, statuses.get(left).reverse());
                statuses.set(right, statuses.get(right).reverse());
                left--;
                right++;
                continue;
            }
            break;
        }
    }

    private enum SwitchStatus {
        ON, OFF;

        SwitchStatus reverse() {
            if (this == ON) {
                return OFF;
            }
            return ON;
        }

        int getNumber() {
            if (this == ON) {
                return 1;
            }
            return 0;
        }
    }
}