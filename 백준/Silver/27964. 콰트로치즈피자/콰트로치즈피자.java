import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        final String WORD = "Cheese";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<String> set = new HashSet<>();
        for (int n=0;n<N;n++){
            String input = st.nextToken();
            if(input.length()<6){
                continue;
            }
            String subStr = input.substring(input.length()-6);
            if(subStr.equals(WORD)){
                set.add(input);
            }
        }

        int size = set.size();
        if(size>=4){
            System.out.print("yummy");
        }else{
            System.out.print("sad");
        }
    }
}
