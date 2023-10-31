import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static char[] str;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Map<String,Integer> map = new HashMap<>();

        for (int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine());
            String fruit = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            if(map.containsKey(fruit)){
                map.replace(fruit,map.get(fruit)+cnt);
            }else{
                map.put(fruit,cnt);
            }
        }
        if(map.values().contains(5)){
            System.out.print("YES");
        }else {
            System.out.print("NO");
        }
    }
}