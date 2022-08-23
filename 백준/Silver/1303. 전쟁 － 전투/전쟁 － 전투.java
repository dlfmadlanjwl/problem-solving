import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static boolean[][] visit;
	static char[][] graph;
	static int N,M;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new char[N][M];
		visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
			for(int j=0;j<M;j++) {
				graph[i][j] = input.charAt(j);
			}
		}
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j]&&graph[i][j]=='W') {
					double count = Math.pow(BFS1(i,j),2);
					sum1+=count;
				}
				if(!visit[i][j]&&graph[i][j]=='B') {
					double count = Math.pow(BFS2(i,j),2);
					sum2+=count;
				}
			}
		}
		System.out.print(sum1+" "+sum2);
		
		
	}
	public static class point{
		int y;
		int x;
		public point(int a,int b) {
			this.y = a;
			this.x = b;
		}
	}
	public static int BFS1(int y,int x) {
		int[] changeY = {-1,1,0,0};
		int[] changeX = {0,0,-1,1};
		int count =0;
		Queue<point>q= new LinkedList<>();
		q.add(new point(y,x));
		visit[y][x] = true;
		while(!q.isEmpty()) {
			point pop = q.poll();
			count++;
			int popY = pop.y;
			int popX = pop.x;
			for(int i=0;i<4;i++) {
				int nowY = popY+changeY[i];
				int nowX = popX+changeX[i];
				if(nowY>=0&&nowY<N&&nowX>=0&&nowX<M) {
					if(!visit[nowY][nowX]&&graph[nowY][nowX]=='W') {
						q.add(new point(nowY,nowX));
						visit[nowY][nowX] = true;
					}
				}
			}
			
		}
		return count;
	}
	public static int BFS2(int y,int x) {
		int[] changeY = {-1,1,0,0};
		int[] changeX = {0,0,-1,1};
		int count =0;
		Queue<point>q= new LinkedList<>();
		q.add(new point(y,x));
		visit[y][x] = true;
		while(!q.isEmpty()) {
			point pop = q.poll();
			count++;
			int popY = pop.y;
			int popX = pop.x;
			for(int i=0;i<4;i++) {
				int nowY = popY+changeY[i];
				int nowX = popX+changeX[i];
				if(nowY>=0&&nowY<N&&nowX>=0&&nowX<M) {
					if(!visit[nowY][nowX]&&graph[nowY][nowX]=='B') {
						q.add(new point(nowY,nowX));
						visit[nowY][nowX] = true;
					}
				}
			}
		}
		return count;
	}
}