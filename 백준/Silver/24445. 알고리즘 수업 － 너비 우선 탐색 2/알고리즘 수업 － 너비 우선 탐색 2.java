import java.util.*;

public class Main{
	static ArrayList<Integer> graph[];
	static int result[];
	static int visit[];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		int R = scan.nextInt();
	
		graph = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}

		visit = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			graph[i].sort(Collections.reverseOrder());
		}
		
		result = new int[N+1];
		
		bfs(N,R);
		
		for(int i=1;i<=N;i++) {
			System.out.println(result[i]);
		}
		
	}
	static void bfs(int N,int R) {
		Queue<Integer> q = new LinkedList<>();
		q.add(R);
		visit[R]=1;
		int num = 1;
		while(!q.isEmpty()) {
			int pop = q.poll();
			result[pop]=num;
			num++;
			for (Integer a : graph[pop]) {
				if (visit[a] == 1)
					continue;
				q.add(a);
				visit[a] = 1;
			}

		}
		return;
	}
}