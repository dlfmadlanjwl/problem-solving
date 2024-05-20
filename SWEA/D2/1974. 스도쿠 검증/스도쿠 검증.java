import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            boolean result = true;
            int[][] sudoku = new int[9][9];
            for(int i=0;i<9;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<9;j++){
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<9;i+=3){
                for(int j=0;j<9;j+=3){
                    if(!check3_3(j, i, sudoku)){
                        result = false;
                        break;
                    }
                }
            }
            for(int i=0;i<9;i++){
                if(!checkWidth(i,sudoku)){
                    result = false;
                    break;
                }
                if(!checkHeight(i,sudoku)){
                    result = false;
                    break;
                }
            }
            if(result) System.out.println("#"+(t+1)+" "+1);
            else System.out.println("#"+(t+1)+" "+0);
        }
    }

    static boolean check3_3(int x, int y, int[][] sudoku){
        boolean[] isVisited = new boolean[10];
        for(int i=y;i<y+3;i++){
            for(int j=x;j<x+3;j++){
                if(isVisited[sudoku[i][j]]){
                    return false;
                }else if(!isVisited[sudoku[i][j]]){
                    isVisited[sudoku[i][j]] = true;
                }
            }
        }
        return true;
    }

    static boolean checkWidth(int y, int[][] sudoku){
        boolean[] isVisited = new boolean[10];
        for(int i=0;i<9;i++){
            if(isVisited[sudoku[y][i]]){
                return false;
            }else{
                isVisited[sudoku[y][i]] = true;
            }
        }
        return true;
    }

    static boolean checkHeight(int x, int[][] sudoku){
        boolean[] isVisited = new boolean[10];
        for(int i=0;i<9;i++){
            if(isVisited[sudoku[i][x]]){
                return false;
            }else{
                isVisited[sudoku[i][x]] = true;
            }
        }
        return true;
    }
}