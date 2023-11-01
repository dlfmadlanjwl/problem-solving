import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] b;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int[] a = new int[n1];
        b = new int[n2];

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n1;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<n2;i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n1;i++) {
            if(!binarySearch(0,n2-1,a[i])){
                list.add(a[i]);
            }
        }

        if(list.size()==0){
            System.out.print(0);
        } else {
            System.out.println(list.size());
            list.stream().forEach(x->System.out.print(x+" "));
        }
    }
    static boolean binarySearch(int start, int end, int goal){
        if(start==end){
            if(b[start]==goal){
                return true;
            }else{
                return false;
            }
        }
        int center = (start+end)/2;
        if(goal<b[center]){
            return binarySearch(start,center,goal);
        }
        else if(goal>b[center]){
            return binarySearch(center+1,end,goal);
        }
        else{
            return true;
        }
    }
}