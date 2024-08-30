import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] land = new int[n*m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                land[i*m+j]= Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(land);

        int height = 0;
        int minSecond = Integer.MAX_VALUE;

        for(int i=land[0];i<=land[land.length-1];i++){
            int inventory = b;
            int second = 0;
            boolean isValid = true;

            for(int j=n*m-1;j>=0;j--){
                if(land[j] > i){
                    inventory += land[j] - i;
                    second += (land[j] - i) * 2;
                }
                if(land[j] < i){
                    if(inventory >= i - land[j]){
                        inventory -= i - land[j];
                        second += i - land[j];
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }
            if(!isValid) continue;

            if(second < minSecond || (second == minSecond && height < i)) {
                minSecond = second;
                height = i;
            }
        }

        System.out.println(minSecond + " " + height);
    }
}