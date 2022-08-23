import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class point{
	int y;
	int x;
	public point(int a,int b) {
		this.y = a;
		this.x = b;
	}
}
public class Main{
	static int count;
	static int N,M;
	static boolean graph[][];
	static boolean visit[][];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		graph = new boolean[N+1][M+1];
		visit = new boolean[N+1][M+1];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			graph[y][x] = true;
		}
		int max = 0;
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(graph[i][j]&&!visit[i][j]) {
					count = 0;
					bfs(i,j);
					if(count > max)max = count;
				}
			}
		}
		System.out.print(max);
	}
	static void bfs(int i,int j) {
		int changeY[] = {0,0,-1,1};
		int changeX[] = {1,-1,0,0};
		Queue<point>q = new LinkedList<>();
		q.add(new point(i,j));
		visit[i][j] = true;
		while(!q.isEmpty()) {
			count++;
			point pop = q.poll();
			int popY = pop.y;
			int popX = pop.x;
			for(int c=0;c<4;c++) {
				int nowY = popY+changeY[c];
				int nowX = popX+changeX[c];
				if(nowY>=1&&nowY<=N&&nowX>=1&&nowX<=M) {
					if(!visit[nowY][nowX]&&graph[nowY][nowX]) {
						q.add(new point(nowY,nowX));
						visit[nowY][nowX] = true;
					}
				}
			}
		}
	}
}