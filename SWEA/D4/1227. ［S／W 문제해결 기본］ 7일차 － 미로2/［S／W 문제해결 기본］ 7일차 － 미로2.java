import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            sc.nextInt();
            char[][] maze = new char[100][100];
            int y = 0, x = 0;
            for(int i=0;i<100;i++){
                String input = sc.next();
                for(int j=0;j<100;j++){
                    maze[i][j] = input.charAt(j);
                    if(maze[i][j] == '2'){
                        y = i;
                        x = j;
                    }
                }
            }
            find = false;
            dfs(maze, y, x, new boolean[100][100]);
            System.out.print("#"+test_case+" ");
            if(find){
                System.out.println(1);
            } else System.out.println(0);
        }
    }
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static boolean find;
    static void dfs(char[][] maze, int y, int x, boolean[][] isVisited){
        if(find) return;
        if(maze[y][x] == '3') {
            find = true;
            return;
        }
        for(int i=0;i<4;i++){
            int newY = y+dy[i];
            int newX = x+dx[i];
            if(newY < 0 || newY >= maze.length || newX < 0 || newX >= maze[0].length) continue;
            if(isVisited[newY][newX] || maze[newY][newX] == '1') continue;
            isVisited[newY][newX] = true;
            dfs(maze, newY, newX, isVisited);
        }
    }
}