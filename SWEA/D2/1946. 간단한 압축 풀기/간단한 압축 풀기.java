import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            String[] keys = new String[N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                map.put(str, x);
                keys[i] = str;
            }
            System.out.println("#"+(t+1));
            int count = 0;
            for(String key: keys){
                for(int j=0;j<map.get(key);j++){
                    System.out.print(key);
                    count++;
                    if(count % 10 == 0) System.out.println();
                }
            }
            System.out.println();
        }
    }
}
