import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }

        int left = 0;
        int right = 0;
        int max = 0;
        while(right < n){
            map.put(arr[right], map.getOrDefault(arr[right], 0)+1);
            right++;

            while(map.keySet().size() > 2){
                map.put(arr[left], map.get(arr[left])-1);
                if(map.get(arr[left]) == 0) map.remove(arr[left]);
                left++;
            }

            max = Math.max(max, right - left);
        }

        System.out.print(max);
    }
}