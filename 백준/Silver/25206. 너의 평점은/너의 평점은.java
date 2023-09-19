import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        HashMap<String,Double>scoreList = new HashMap(){{
            put("A+",4.5);
            put("A0",4.0);
            put("B+",3.5);
            put("B0",3.0);
            put("C+",2.5);
            put("C0",2.0);
            put("D+",1.5);
            put("D0",1.0);
            put("F",0.0);
        }};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Double scoreSum = 0.0;
        Double sum = 0.0;
        for(int i=0;i<20;i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            Double n = Double.parseDouble(st.nextToken());
            String strScore = st.nextToken();
            if(strScore.equals("P")){
                continue;
            }
            Double score = scoreList.get(strScore);
            scoreSum += score * n;
            sum += n;
        }
        System.out.print(scoreSum/sum);
    }
}