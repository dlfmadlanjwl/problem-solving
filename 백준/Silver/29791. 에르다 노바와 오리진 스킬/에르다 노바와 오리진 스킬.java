import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] distance, weight;
    static int L,N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(A);
        Collections.sort(B);
        int countA = 0, countB=0;
        int skillUsed = Integer.MIN_VALUE;
        for (int i=0;i<N;i++){
            if (skillUsed+100 > A.get(i)){
                continue;
            }else{
                skillUsed=A.get(i);
                countA++;
            }
        }
        skillUsed=Integer.MIN_VALUE;
        for (int i=0;i<M;i++){
            if (skillUsed+360 > B.get(i)){
                continue;
            }else{
                skillUsed=B.get(i);
                countB++;
            }
        }
        System.out.print(countA+" "+countB);
    }
}
