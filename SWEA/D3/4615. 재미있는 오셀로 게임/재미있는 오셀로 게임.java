import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		char[] colors = {'0', 'B', 'W'};
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] board = new char[n+1][n+1];
            board[n/2-1][n/2-1] = 'W';
            board[n/2][n/2] = 'W';
            board[n/2-1][n/2] = 'B';
            board[n/2][n/2-1] = 'B';
            
            for(int i=0;i<m;i++){
            	int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                boolean isBlack = sc.nextInt() == 1;
                if(isBlack) board[y][x] = 'B';
                else board[y][x] = 'W';
                find(board, y, x);
            }
            
            int w = 0;
            int b = 0;
            for(int i=0;i<n;i++){
            	for(int j=0;j<n;j++){
                	if(board[i][j] == 'W') w++;
                    if(board[i][j] == 'B') b++;
                }
            }
            System.out.println("#"+test_case+" "+b+" "+w);
		}
	}
    
    static void find(char[][] board, int y, int x){
        for(int d=0;d<8;d++){            
            if(!check(board, d, y, x)) continue;
              change(board, d, y, x);
        }
    }
    static void change(char[][] board, int d, int y , int x){
    	int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
        int newY = y + dy[d];
        int newX = x + dx[d];
        while(true){
            if(board[newY][newX] == board[y][x]){
                return;
            }            
            if(board[newY][newX] == 'B') board[newY][newX] = 'W';
            else board[newY][newX] = 'B';
            newY += dy[d];
            newX += dx[d];
        }
    }
        
        
    static boolean check(char[][] board, int d, int y , int x){
    	int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
        int newY = y;
        int newX = x;
        while(true){
            newY += dy[d];
            newX += dx[d];
            if(newY < 0 || newX < 0 || newY >= board.length || newX >= board[0].length) return false;
            if(!(board[newY][newX] == 'B' || board[newY][newX] == 'W')) return false;
            if(board[newY][newX] == board[y][x]){
                return true;
            }
        }
    }
}