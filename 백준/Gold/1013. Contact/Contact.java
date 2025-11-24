import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(bufferedReader.readLine());
        Pattern reg = Pattern.compile("^(100+1+|01)+$");
        for (int testCase = 0; testCase < t; testCase++) {
            String input = bufferedReader.readLine();
            if (reg.matcher(input).matches()) {
                stringBuilder.append("YES").append("\n");
            } else {
                stringBuilder.append("NO").append("\n");
            }
        }
        System.out.println(stringBuilder);
    }
}