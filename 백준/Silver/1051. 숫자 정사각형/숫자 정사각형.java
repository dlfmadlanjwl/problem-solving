import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[][] square = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                square[i][j] = input.charAt(j) - '0';
            }
        }

        for (int size = Math.min(n, m); size > 0; size--) {
            for (int i = 0; i + size - 1 < n; i++) {
                for (int j = 0; j + size - 1 < m; j++) {
                    if (square[i][j] != square[i + size - 1][j + size - 1]) {
                        continue;
                    }
                    if (square[i][j] != square[i][j + size - 1]) {
                        continue;
                    }
                    if (square[i][j] != square[i + size - 1][j]) {
                        continue;
                    }
                    System.out.println(size * size);
                    return;
                }
            }
        }
    }
}