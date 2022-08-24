import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Integer>graph[];
	static boolean visit[];
	static int N;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		visit = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		BFS();
	}
	public static void BFS() {
		Queue<Integer>q = new LinkedList<>();
		int count = 0;
		q.add(1);
		visit[1] = true;
		ArrayList<Integer>arr = new ArrayList<>();
		while(!q.isEmpty()) {
			arr.clear();
			int size = q.size();
			for(int i=0;i<size;i++) {
				int pop = q.poll();
				arr.add(pop);
				for(int j:graph[pop]) {
					if(!visit[j]&&graph[pop].contains(j)) {
						q.add(j);
						visit[j] = true;
					}
				}
			}
			count++;
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i)<min)min = arr.get(i);
		}
		System.out.print(min+" "+(count-1)+" "+arr.size());
	}
}	