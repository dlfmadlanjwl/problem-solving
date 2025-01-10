import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int x = -1;
        for(int i=0;i<n-1;i++){
            if(list.get(i) < list.get(i + 1)){
                x = i;
            }
        }

        if(x == -1){
            System.out.print(-1);
            return;
        }

        for(int i=list.size()-1;i>x;i--){
            if(list.get(i) > list.get(x)){
                int tmp = list.get(i);
                list.set(i,  list.get(x));
                list.set(x, tmp);
                break;
            }
        }

        for(int i=0;i<=x;i++){
            System.out.print(list.get(i) + " ");
        }

        for(int i=list.size()-1;i>x;i--){
            System.out.print(list.get(i) + " ");
        }
    }
}