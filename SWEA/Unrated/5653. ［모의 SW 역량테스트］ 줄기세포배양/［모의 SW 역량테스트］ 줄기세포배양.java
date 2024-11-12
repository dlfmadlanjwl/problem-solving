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
            int m = sc.nextInt();
            int k = sc.nextInt();
            Node[][] arr = new Node[800][800];
            Queue<Position> q = new LinkedList<>();
            for(int i=arr.length/2;i<arr.length/2 +n;i++){
            	for(int j=arr[0].length/2;j<arr[0].length/2 + m;j++){
            		int value = sc.nextInt();
            		if(value == 0) continue;
            		q.add(new Position(i,j, 0));
                	arr[i][j] = new Node(value, 0);
                }
            }
                        
            bfs(q, arr, k);
            int count = 0;
           for(int i=0;i<arr.length;i++){
                	for(int j=0;j<arr[0].length;j++){
                    	if(arr[i][j] != null && k - arr[i][j].birth < arr[i][j].value * 2) count++;
                    }
           }
            System.out.println("#"+test_case+" "+count);
		}
	}
    static void bfs(Queue<Position> q, Node[][] arr, int k){        
    	int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        while(true) {
        	Position now = q.poll();
        	if(now.depth == k + 1) {
        		break;
        	}
        	
        	if(now.depth - arr[now.y][now.x].birth == arr[now.y][now.x].value + 1) {
        		for(int i=0;i<4;i++){
                	int newY = now.y + dy[i];
                    int newX = now.x + dx[i];
                    if(newY < 0 || newX < 0 || newY >= arr.length || newX >= arr[0].length) continue;
                    Node next = arr[newY][newX];
                    if(next == null){
                    	arr[newY][newX] = new Node(arr[now.y][now.x].value, now.depth);
                        q.add(new Position(newY, newX, now.depth + 1));
                    } else if(next.birth == now.depth && next.value < arr[now.y][now.x].value) {
                    	next.value = arr[now.y][now.x].value;
                        q.add(new Position(newY, newX, now.depth + 1));
                    }
                }
        	}
        	
        	if(now.depth - arr[now.y][now.x].birth == arr[now.y][now.x].value * 2)continue;
        	q.add(new Position(now.y, now.x, now.depth + 1));
        	
        }
        
    }
    
    static class Position{
    	int y;
    	int x;
    	int depth;
    	Position(int y, int x, int depth){
    		this.y = y;
    		this.x = x;
    		this.depth = depth;
    	}
    }
        
    static class Node{
    	int value;
        int birth;
        Node(int value, int birth){
        	this.value = value;
            this.birth = birth;
        }
    }
}