import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static char[][] arr;
    private static int N;
    private static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0);
        if(result) System.out.print("YES");
        else System.out.print("NO");
    }

    private static void dfs(int depth){
        if (depth == 3){
            if(findStudent()) result = true;
            return;
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 'X'){
                    arr[i][j] = 'O';
                    dfs(depth+1);
                    arr[i][j] = 'X';
                }
            }
        }
    }

    private static boolean findStudent(){
        boolean isSafe = true;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] == 'T'){
                    if(!isSafe(j,i)) isSafe = false;
                }
            }
        }
        return isSafe;
    }

    private static boolean isSafe(int teacherX, int teacherY){
        boolean isSafe = true;
        boolean blocked = false;
        for(int i=teacherY;i>=0;i--){
            if(arr[i][teacherX] == 'O') blocked = true;
            if(arr[i][teacherX] == 'S' && !blocked) isSafe = false;
        }
        blocked = false;
        for(int i=teacherY;i<N;i++){
            if(arr[i][teacherX] == 'O') blocked = true;
            if(arr[i][teacherX] == 'S' && !blocked) isSafe = false;
        }
        blocked = false;
        for(int i=teacherX;i<N;i++){
            if(arr[teacherY][i] == 'O') blocked = true;
            if(arr[teacherY][i] == 'S' && !blocked) isSafe = false;
        }
        blocked = false;
        for(int i=teacherX;i>=0;i--){
            if(arr[teacherY][i] == 'O') blocked = true;
            if(arr[teacherY][i] == 'S' && !blocked) isSafe = false;
        }

        return isSafe;
    }
}