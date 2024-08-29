import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] answer = cut(paper, 0, 0, n-1, n-1);
        System.out.print(answer[0]+"\n"+answer[1]);
    }

    static int[] cut(int[][] paper, int startY, int startX, int endY, int endX){
        boolean isDifferent = isEqualAll(paper, startY, startX, endY, endX);

        int[] count = {0, 0};
        if(!isDifferent){
            int midY = startY + (endY-startY)/2;
            int midX = startX + (endX-startX)/2;

            int[] result1 = cut(paper, startY, startX, midY, midX);
            int[] result2 = cut(paper, midY+1, startX, endY, midX);
            int[] result3 = cut(paper, startY, midX+1, midY, endX);
            int[] result4 = cut(paper, midY+1, midX+1, endY, endX);

            count[0] += result1[0] + result2[0] + result3[0] + result4[0];
            count[1] += result1[1] + result2[1] + result3[1] + result4[1];
        } else {
            if(paper[startY][startX] == 0){
                count[0] = 1;
            } else {
                count[1] = 1;
            }
        }

        return count;
    }

    static boolean isEqualAll(int[][] arr, int startY, int startX, int endY, int endX){
        for(int i=startY;i<=endY;i++){
            for(int j=startX;j<=endX;j++){
                if(arr[startY][startX] != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}