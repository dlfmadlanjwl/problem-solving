import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] sudoku = new int[9][9];
        int zeroCount = 0;
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if(sudoku[i][j] == 0) zeroCount++;
            }
        }
        dfs(sudoku, 0, zeroCount);

    }

    static void dfs(int[][] sudoku, int depth, int target){
        if (depth == target) {
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(sudoku[i][j]+" ");
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(sudoku[i][j] == 0){
                    for(int k=1;k<=9;k++){
                        if(isValid(sudoku, i, j, k)){
                            sudoku[i][j] = k;
                            dfs(sudoku, depth+1, target);
                            sudoku[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }
    }

    static boolean isValid(int[][] sudoku, int y, int x, int value){
        for(int i=0;i<9;i++){
            if(sudoku[y][i] == value) return false;
            if(sudoku[i][x] == value) return false;
        }
        for(int i=y/3*3;i<y/3*3+3;i++){
            for(int j=x/3*3;j<x/3*3+3;j++){
                if(sudoku[i][j] == value) return false;
            }
        }
        return true;
    }
}