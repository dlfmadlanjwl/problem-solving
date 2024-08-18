import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dfs(n, m, new ArrayList<>());
    }

    static void dfs(int n, int m, List<Integer> list){
        if(list.size() == m){
            for(int i : list){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            if(!list.contains(i)){
                list.add(i);
                dfs(n, m, list);
                list.remove(list.size()-1);
            }
        }
    }
}