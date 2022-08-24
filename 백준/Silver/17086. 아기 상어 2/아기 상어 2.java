import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	public static class point{
		int y;
		int x;
		int level;
		public point(int a,int b,int c) {
			this.y=a;
			this.x=b;
			this.level=c;
		}
	}
	static boolean[][] visit;
	static char[][] graph;
	static int N,M;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				graph[i][j] = st.nextToken().charAt(0);
			}
		}
		int max = -1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visit = new boolean[N][M];
				int tmp = BFS(i,j)-1;
				
				if(tmp>max) {
					max = tmp;
				}
			}
			
		}
		System.out.print(max);
	}
	public static int BFS(int y,int x) {
		int[] changeY = {0,0,-1,1,1,-1,-1,1};
		int[] changeX = {1,-1,0,0,1,-1,1,-1};
		Queue<point>q = new LinkedList<>();
		q.add(new point(y,x,1));
		visit[y][x] = true;
		while(!q.isEmpty()) {
			point pop = q.poll();
			int popY = pop.y;
			int popX = pop.x;
			int popLevel = pop.level;
			if(graph[popY][popX]=='1') {
				return popLevel;
			}
			for(int i=0;i<8;i++) {
				int nowY = popY+changeY[i];
				int nowX = popX+changeX[i];
				if(nowY>=0&&nowY<N&&nowX>=0&&nowX<M) {
					if(!visit[nowY][nowX]) {
						q.add(new point(nowY,nowX,popLevel+1));
						visit[nowY][nowX] = true;
					}
				}
			}
		}
		return 0;
	}
}