import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            char[][] board = new char[n][n]; 
            for(int i=0;i<n;i++){
                String input = sc.next();
            	for(int j=0;j<n;j++){
                	board[i][j] = input.charAt(j);
                }
            }
            
            int count = 0;
            for(int i=0;i<n;i++){
            	for(int j=0;j<n;j++){
                	if(board[i][j] == '.' && count(board, i, j) == 0){
                    	count++;
                        board[i][j] = 'c';
                        bfs(board, i, j);
                    }
                }
            }
            for(int i=0;i<n;i++){
            	for(int j=0;j<n;j++){
                	if(board[i][j] == '.'){
                    	count++;
                    }
                }
            }
            System.out.println("#"+test_case+" "+count);
		}
	}
    
    static void bfs(char[][] board, int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        
        while(!q.isEmpty()){
            Node now = q.poll();
            y = now.y;
            x = now.x;
            for(int i=y-1;i<=y+1;i++){
                for(int j=x-1;j<=x+1;j++){
                    if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) continue;
                    if(i == y && j == x) continue;
                    if(board[i][j] == '.') {
                        int count = count(board,i,j);
                        board[i][j] =  'c';
                        if(count == 0){
                        	q.add(new Node(i,j));
                        }
                    }
                }
            }
        }
    }
    
    static int count(char[][] board, int y, int x){
        int count = 0;
    	for(int i=y-1;i<=y+1;i++){
        	for(int j=x-1;j<=x+1;j++){
            	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) continue;
                if(i == y && j == x) continue;
                if(board[i][j] == '*') count++;
            }
        }
        
        return count;
    }
    
    static class Node{
    	int y;
        int x;
        
        Node(int y, int x){
        	this.y = y;
            this.x = x;
        }
    }
}