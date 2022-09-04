import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static public void main(String args[])throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
     
      boolean[] num = new boolean[N+1];

      int count = 0;

      for(int i = 2; i <= N; i++) {
          num[i] = true;
      }

      for(int i = 2; i <= N; i++) {
          for(int j = i; j <= N; j += i) {
              if(!num[j])
                  continue;
              num[j] = false;
              count ++;
              if(count == K) {
                  System.out.println(j);
                  System.exit(0);
              }
          }
      }
  }
}