import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[m];
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> result = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;
        while(idx1 < n && idx2 < m){
            if(arr1[idx1] <= arr2[idx2]){
                result.add(arr1[idx1]);
                idx1++;
            } else {
                result.add(arr2[idx2]);
                idx2++;
            }
        }
        for(int i=idx1;i<n;i++){
            result.add(arr1[i]);
        }
        for(int i=idx2;i<m;i++){
            result.add(arr2[i]);
        }

        StringBuilder sb = new StringBuilder();
        result.forEach(x->sb.append(x).append(" "));
        System.out.println(sb);
    }
}