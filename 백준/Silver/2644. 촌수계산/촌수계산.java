import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	static int result=-1;
	static ArrayList<Integer> graph[];
	static int visit[];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = scan.nextInt();
		int a = scan.nextInt(); int b = scan.nextInt();
		int m = scan.nextInt();
	
		graph = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		visit = new int[N+1];
		for(int i=0;i<m;i++) {
			int tmp1 = scan.nextInt();
			int tmp2 = scan.nextInt();
			graph[tmp1].add(tmp2);
			graph[tmp2].add(tmp1);
		}
		dfs(a,b,0);
		sb.append(result);
		System.out.print(sb);
	}
	static void dfs(int a,int b,int cnt) {
		if(a==b) {
			result = cnt;
		}
		visit[a] = 1;
		for(int i : graph[a]) {
			if(visit[i]!=1) {
				dfs(i,b,cnt+1);
			}
		}
		
		
	}
}