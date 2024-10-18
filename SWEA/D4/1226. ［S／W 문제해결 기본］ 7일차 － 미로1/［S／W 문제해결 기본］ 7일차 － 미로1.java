import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
            int[][] maze = new int[16][16];
            for(int i=0;i<16;i++){
                String input = sc.next();
            	for(int j=0;j<16;j++){
                	maze[i][j] = input.charAt(j) - '0';
                }
            }
            
            System.out.print("#"+test_case+" ");
            if(dfs(maze, new boolean[16][16], 1, 1)){
            	System.out.println(1);
            } else {
            	System.out.println(0);
            }
		}
	}
    
    static boolean dfs(int[][] maze, boolean[][] isVisited, int y, int x){
        if(y == 13 && x == 13) return true;
       	boolean possible = false;
    	int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        for(int i=0;i<4;i++){
        	int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newY >= maze.length || newX < 0 || newX >= maze[0].length) continue;
            if(isVisited[newY][newX] || maze[newY][newX] == 1) continue;
            
            isVisited[newY][newX] = true;
            if(dfs(maze, isVisited, newY, newX)) possible = true;
        }
        
        return possible;
    }
}