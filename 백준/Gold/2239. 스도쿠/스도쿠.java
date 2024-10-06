import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
    static class Blank{
        int y;
        int x;

        Blank(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoku = new int[9][9];
        List<Blank> blanks = new ArrayList<>();
        for(int i=0;i<9;i++){
            String input = br.readLine();
            for(int j=0;j<9;j++){
                sudoku[i][j] = input.charAt(j) - '0';
                if(sudoku[i][j] == 0) blanks.add(new Blank(i, j));
            }
        }

        dfs(sudoku, blanks, 0);
    }

    static void dfs(int[][] sudoku, List<Blank> blanks, int idx){
        if(idx == blanks.size()){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    System.out.print(sudoku[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        Blank blank = blanks.get(idx);
        for(int k=1;k<=9;k++){
            if(validate(sudoku, blank.y, blank.x, k)){
                sudoku[blank.y][blank.x] = k;
                dfs(sudoku, blanks, idx+1);
                sudoku[blank.y][blank.x] = 0;
            }
        }
    }

    static boolean validate(int[][] sudoku, int y, int x, int value){
        if(checkHorizontal(sudoku, y, value) && checkVertical(sudoku, x, value) && check3x3(sudoku, y, x , value)){
            return true;
        }
        return false;
    }

    static boolean checkHorizontal(int[][] sudoku, int y, int value){
        boolean[] isPresent = new boolean[10];
        for(int i=0;i<9;i++){
            isPresent[sudoku[y][i]] = true;
        }
        if(isPresent[value]) return false;
        return true;
    }

    static boolean checkVertical(int[][] sudoku, int x, int value){
        boolean[] isPresent = new boolean[10];
        for(int i=0;i<9;i++){
            isPresent[sudoku[i][x]] = true;
        }
        if(isPresent[value]) return false;
        return true;
    }

    static boolean check3x3(int[][] sudoku, int y, int x, int value){
        boolean[] isPresent = new boolean[10];
        for(int i=y/3*3;i<y/3*3+3;i++){
            for(int j=x/3*3;j<x/3*3+3;j++){
                isPresent[sudoku[i][j]] = true;
            }
        }
        if(isPresent[value]) return false;
        return true;
    }
}