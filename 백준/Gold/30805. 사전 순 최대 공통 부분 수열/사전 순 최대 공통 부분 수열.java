import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        int max = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(st.nextToken());
            a.add(x);
            max = Math.max(max, x);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int x = Integer.parseInt(st.nextToken());
            b.add(x);
            max = Math.max(max, x);
        }

        List<Integer> answer = new ArrayList<>();

        int indexA = 0, indexB = 0;
        for(int i=max;i>0;i--){
            while(true){
                int idxA = indexOf(a, i, indexA);
                int idxB = indexOf(b, i ,indexB);

                if(idxA == -1 || idxB == -1) break;
                answer.add(i);
                indexA = idxA + 1;
                indexB = idxB + 1;
            }
        }

        System.out.println(answer.size());
        answer.forEach(x->System.out.print(x + " "));
    }

    static int indexOf(List<Integer> list, int value, int startIndex){
        for(int i=startIndex;i<list.size();i++){
            if(list.get(i).equals(value)){
                return i;
            }
        }

        return -1;
    }
}