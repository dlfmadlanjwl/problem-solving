import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer>aList = new ArrayList<>();
        List<Integer>bList = new ArrayList<>();

        int[] scores = {1,2,4,8,16,32,64,128,256,512};

        for(int i=scores.length-1;i>=0;i--){
            if(a>=scores[i]){
                a-=scores[i];
                aList.add(scores[i]);
            }
        }
        for(int i=scores.length-1;i>=0;i--){
            if(b>=scores[i]){
                b-=scores[i];
                bList.add(scores[i]);
            }
        }

        int res = 0;
        for(int i=scores.length-1;i>=0;i--) {
            if (aList.contains(scores[i]) && !bList.contains(scores[i])) {
                res += scores[i];
            } else if (bList.contains(scores[i]) && !aList.contains(scores[i])) {
                res += scores[i];
            }
        }
        System.out.print(res);
    }
}
