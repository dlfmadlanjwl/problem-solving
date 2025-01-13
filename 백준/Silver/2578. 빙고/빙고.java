import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] bingo = new int[5][5];
        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                int x = Integer.parseInt(st.nextToken());
                convertToZero(x, bingo);
                if(isBingo(bingo)){
                    System.out.println(i * 5 + (j+1));
                    return;
                }
            }
        }
    }

    static void convertToZero(int x, int[][] bingo){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(bingo[i][j] == x) {
                    bingo[i][j] = 0;
                    return;
                }
            }
        }
    }

    static boolean isBingo(int[][] bingo){
        int bingoCnt = 0;
        for(int i=0;i<5;i++){
            int count = 0;
            for(int j=0;j<5;j++){
                if(bingo[i][j] == 0){
                    count++;
                }
            }
            if(count == 5) bingoCnt++;
            count = 0;
            for(int j=0;j<5;j++){
                if(bingo[j][i] == 0){
                    count++;
                }
            }
            if(count == 5) bingoCnt++;
        }

        int count = 0;
        for(int i=0;i<5;i++){
            if(bingo[i][i] == 0) count++;
        }
        if(count == 5) bingoCnt++;

        count = 0;
        for(int i=0;i<5;i++){
            if(bingo[i][4-i] == 0) count++;
        }
        if(count == 5) bingoCnt++;

        return bingoCnt > 2;
    }
}