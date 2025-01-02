import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] inputA = new int[n];
        for(int i=0;i<n;i++){
            inputA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] inputB = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            inputB[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sumsA = new ArrayList<>();
        List<Integer> sumsB = new ArrayList<>();
        for(int i=0;i<inputA.length;i++){
            int sum = 0;
            for(int j=i;j<inputA.length;j++){
                sum += inputA[j];
                sumsA.add(sum);
            }
        }
        for(int i=0;i<inputB.length;i++){
            int sum = 0;
            for(int j=i;j<inputB.length;j++){
                sum += inputB[j];
                sumsB.add(sum);
            }
        }

        Collections.sort(sumsA);
        Collections.sort(sumsB);

        int left = 0;
        int right = sumsB.size() - 1;

        long answer = 0;
        while(left < sumsA.size() && 0 <= right) {
            int nowA = sumsA.get(left);
            int nowB = sumsB.get(right);
            int sum = nowA + nowB;

            if(sum == t){
                long aCnt = 0;
                while(left < sumsA.size() && sumsA.get(left).equals(nowA)){
                    aCnt++;
                    left++;
                }

                long bCnt = 0;
                while(0 <= right && sumsB.get(right).equals(nowB)){
                    bCnt++;
                    right--;
                }

                answer += aCnt * bCnt;
            } else if(sum < t){
                left++;
            } else if(sum > t){
                right--;
            }
        }

        System.out.print(answer);
    }
}