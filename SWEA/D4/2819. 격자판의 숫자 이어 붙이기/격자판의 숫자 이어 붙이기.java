import java.util.*;

class Solution
{
    static Set<String> set;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int[][] board = new int[4][4];
            set = new HashSet<>();
			for(int i=0;i<4;i++){
            	for(int j=0;j<4;j++){
                	board[i][j] = sc.nextInt();
                }
            }
            
            for(int i=0;i<4;i++){
            	for(int j=0;j<4;j++){
                	dfs("", board, i, j);
                }
            }
            
            System.out.println("#"+test_case+" "+set.size()); 
		}
	}
    
    static void dfs(String number, int[][] board, int y, int x){
    	if(number.length() == 7) {
        	set.add(number);
            return;
        }
        
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        for(int i=0;i<4;i++){
        	int newY = y + dy[i];
            int newX = x + dx[i];
            if(newY < 0 || newY >= board.length || newX < 0 || newX >= board[0].length)continue;
            dfs(number+board[newY][newX], board, newY, newX);
        }
    }
}