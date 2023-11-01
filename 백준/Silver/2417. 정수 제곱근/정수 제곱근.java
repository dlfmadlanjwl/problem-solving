import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long min = 0;
        long max = (long)Math.pow(2,32);

        long res = binarySearch(min,max,n);
        System.out.println(res);
    }

    static long binarySearch(long start,long end, long n){
        if(start==end){
            return start;
        }
        long center = (start+end)/2;
        if(n<Math.pow(center,2)){
            return binarySearch(start,center,n);
        }else if(n>Math.pow(center,2)){
            return binarySearch(center+1,end,n);
        }else{
            return center;
        }
    }
}