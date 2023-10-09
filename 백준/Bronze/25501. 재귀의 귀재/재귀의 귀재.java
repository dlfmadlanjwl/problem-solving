import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            String s = br.readLine();
            int[] res = isPalindrome(s);
            System.out.println(res[0]+" "+res[1]);
        }
    }

    public static int[] recursion(String s, int l, int r,int count){
        if(l >= r) return new int[]{1,count};
        else if(s.charAt(l) != s.charAt(r)) return new int[]{0,count};
        else return recursion(s, l+1, r-1,count+1);
    }

    public static int[] isPalindrome(String s){
        int count = 1;
        int[] res = recursion(s,0,s.length()-1,count);
        return res;
    }
}
