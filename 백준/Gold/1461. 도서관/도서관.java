import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        List<Integer> leftPositions = new ArrayList<>();
        List<Integer> rightPositions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int position = Integer.parseInt(stringTokenizer.nextToken());
            if (position > 0) {
                rightPositions.add(position);
            } else {
                leftPositions.add(position * -1);
            }
        }

        leftPositions.sort(Collections.reverseOrder());
        rightPositions.sort(Collections.reverseOrder());

        int distance = 0;
        for (int i = 0; i < leftPositions.size(); i += m) {
            distance += leftPositions.get(i) * 2;
        }

        for (int i = 0; i < rightPositions.size(); i += m) {
            distance += rightPositions.get(i) * 2;
        }

        int leftMax = leftPositions.stream().mapToInt(i -> i).max().orElse(0);
        int rightMax = rightPositions.stream().mapToInt(i -> i).max().orElse(0);

        System.out.println(distance - Math.max(leftMax, rightMax));
    }
}
