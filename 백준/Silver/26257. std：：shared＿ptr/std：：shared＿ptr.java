import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] object;
    static int[] pointer;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        object = new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            object[i] = new ArrayList<>();
        }
        pointer = new int[M+1];

        for (int m=1;m<=M;m++){
            int a = Integer.parseInt(br.readLine());
            object[a].add(m);
            pointer[m] = a;
        }
        for (int q=0;q<Q;q++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = 0;
            if(st.hasMoreTokens()){
                b = Integer.parseInt(st.nextToken());
            }
            if(op.equals("assign")){
                assign(a,b);
            }else if(op.equals("swap")){
                swap(a,b);
            } else if (op.equals("reset")) {
                reset(a);
            }
        }
        int cnt = 0;
        for(int i=1;i<=N;i++){
            if(object[i].size()!=0){
                cnt++;
            }
        }
        sb.append(cnt+"\n");
        for(int i=1;i<=N;i++){
            if(object[i].size()!=0){
                sb.append(i+"\n");
            }
        }
        System.out.print(sb);
    }
    static void assign(int x, int y){
        object[pointer[y]].add(x);
        int idx = object[pointer[x]].indexOf(x);
        object[pointer[x]].remove(idx);
        pointer[x] = pointer[y];
    }
    static void swap(int x, int y){
        object[pointer[y]].add(x);
        object[pointer[x]].add(y);
        int idx = object[pointer[x]].indexOf(x);
        object[pointer[x]].remove(idx);
        idx = object[pointer[y]].indexOf(y);
        object[pointer[y]].remove(idx);
        int tmp = pointer[x];
        pointer[x] = pointer[y];
        pointer[y] = tmp;
    }
    static void reset(int x){
        int idx = object[pointer[x]].indexOf(x);
        object[pointer[x]].remove(idx);
        object[0].add(x);
        pointer[x] = 0;
    }
}
