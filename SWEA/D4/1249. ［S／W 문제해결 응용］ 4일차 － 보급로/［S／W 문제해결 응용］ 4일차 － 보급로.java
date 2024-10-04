import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
				int n = Integer.parseInt(br.readLine());
            	int[][] graph = new int[n][n];
            	for(int i=0;i<n;i++){
                	String input = br.readLine();
                    for(int j=0;j<n;j++){
                    	graph[i][j] = input.charAt(j) - '0';
                    }
                }
            
            	int[][] distance = dijkstra(graph);
            	System.out.println("#"+test_case+" "+distance[n-1][n-1]);
		}
	}
    
    static int[][] dijkstra(int[][] graph){
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};
    	boolean[][] isVisited = new boolean[graph.length][graph.length];
        int[][] distance = new int[graph.length][graph.length];
        for(int[] arr : distance) Arrays.fill(arr, Integer.MAX_VALUE);
        distance[0][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
        	public int compare(Node a, Node b){
            	return distance[a.y][a.x] - distance[b.y][b.x];
            }
        });
        pq.add(new Node(0, 0));
        while(!pq.isEmpty()){
        	Node now = pq.poll();
            if(isVisited[now.y][now.x]) continue;
            isVisited[now.y][now.x] = true;
            for(int i=0;i<4;i++){
            	int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY < 0 || newY >= graph.length || newX < 0 || newX >= graph.length) continue;
                if(isVisited[newY][newX]) continue;
                
                if(distance[newY][newX] > distance[now.y][now.x] + graph[newY][newX]){
                    distance[newY][newX] = distance[now.y][now.x] + graph[newY][newX];
                	pq.add(new Node(newY, newX));	
                }
            }
        }
        return distance;
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