import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int result = 0;

        while(true){ 
            int count = 0; 
            int num = N; 
            while(num!=0){
                if(num%2==1){
                    count+=1;
                }
                num/=2;
            }

            if(count<=K){ 
                break;
            } 
            result++;
            N++; 
        }
        System.out.print(result);
    }
}