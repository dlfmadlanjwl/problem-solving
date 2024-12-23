import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for(int j=0;j<4;j++){
                if(Integer.parseInt(st.nextToken()) == 0) cnt++;
            }
            String result = "";
            switch (cnt) {
                case 1 :
                    result = "A";
                    break;
                case 2 :
                    result = "B";
                    break;
                case 3 :
                    result = "C";
                    break;
                case 4 :
                    result = "D";
                    break;
                case 0 :
                    result = "E";
                    break;
            }
            System.out.println(result);
        }
    }
}
