import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
            int[][] ladder = new int[100][100];
            for(int i=0;i<100;i++){
            	for(int j=0;j<100;j++){
                	ladder[i][j] = sc.nextInt();
                }
            }
            
            int min = Integer.MAX_VALUE;
            int answer = 0;
            for(int i=0;i<100;i++){
                if(ladder[0][i] == 1) {
                    int length = bfs(ladder, i);
                    if(length < min){
                    	min = length;
                        answer = i;
                    }
                }
            }
            
            System.out.println("#"+test_case+" "+answer);
		}
	}
    
    static int bfs(int[][] ladder, int startX){
    	Queue<Node> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[100][100];
        q.add(new Node(0, startX, 0));
        isVisited[0][startX] = true;
        
        int[] dy = {0, 0, 1};
        int[] dx = {-1, 1, 0};
        int length = 0;
        while(!q.isEmpty()){
        	Node now = q.poll();
            if(now.y == 99){
            	return length = now.dist;
            }
            for(int i=0;i<3;i++){
            	int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY < 0 || newY >= ladder.length || newX < 0 || newX >= ladder[0].length) continue;
                if(isVisited[newY][newX]) continue;
                if(ladder[newY][newX] == 1){
                	isVisited[newY][newX] = true;
                    q.add(new Node(newY, newX, now.dist+1));
                    break;
                }
            }
        }
        
        return length;
    }
    
    static class Node{
    	int y;
        int x;
        int dist;
        Node(int y, int x, int dist){
        	this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
}