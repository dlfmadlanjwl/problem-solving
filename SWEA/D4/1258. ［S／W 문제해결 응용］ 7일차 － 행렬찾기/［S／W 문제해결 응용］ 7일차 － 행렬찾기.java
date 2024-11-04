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
            int[][] arr = new int[n][n];
            for(int i=0;i<n;i++){
            	for(int j=0;j<n;j++){
                	arr[i][j] = sc.nextInt();
                }
            }
            boolean[][] isVisited = new boolean[n][n];
            List<Node> list = new ArrayList<>();
            for(int i=0;i<n;i++){
            	for(int j=0;j<n;j++){
                    if(isVisited[i][j] || arr[i][j] == 0) continue;
                	list.add(bfs(arr, isVisited, i, j));
                }
            }
            list.sort(new Comparator<Node>(){
            	public int compare(Node a, Node b){
                	if(a.y * a.x == b.y * b.x){
                    	return a.y - b.y;
                    }
                    return a.y * a.x - b.y * b.x;
                }
            });
            
            System.out.print("#"+test_case+" "+list.size()+" ");
            for(int i=0;i<list.size();i++){
            	System.out.print(list.get(i).y + " "+list.get(i).x+" ");
            }
            System.out.println();
		}
	}
    
    static Node bfs(int[][] arr, boolean[][] isVisited, int y, int x){
    	int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        isVisited[y][x] = true;
        int maxY = y;
        int maxX = x;
        while(!q.isEmpty()){
        	Node now = q.poll();
            maxY = Math.max(maxY, now.y);
            maxX = Math.max(maxX, now.x);
            for(int i=0;i<4;i++){
            	int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY < 0 || newY >= arr.length || newX < 0 || newX >= arr[0].length) continue;
                if(arr[newY][newX] == 0 || isVisited[newY][newX]) continue;
                q.add(new Node(newY, newX));
                isVisited[newY][newX] = true;
            }
        }
        return new Node(maxY - y + 1, maxX - x + 1);
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