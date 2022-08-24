import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static char[][] graph;
	static boolean[][] visit;
	static int M,N;
	static int result;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new char[M][N];
		visit = new boolean[M][N];
		for(int i=0;i<M;i++) {
			String input = br.readLine();
			for(int j=0;j<N;j++) {
				graph[i][j] = input.charAt(j);
			}
		}
		result = 0;
		for(int i=0;i<N;i++) {
			if(!visit[0][i]&&graph[0][i]=='0') {
				DFS(0,i);
			}
		}
		if(result ==0) {
			System.out.print("NO");
		}
		else System.out.print("YES");
	}
	public static void DFS(int y,int x) {
		if(y==M-1)result = 1;
		int changeY[] = {0,0,-1,1};
		int changeX[] = {1,-1,0,0};
		visit[y][x] = true;
		for(int i=0;i<4;i++) {
			int nowY = y+changeY[i];
			int nowX = x+changeX[i];
			if(nowY>=0&&nowY<M&&nowX>=0&&nowX<N) {
				if(!visit[nowY][nowX]&&graph[nowY][nowX]=='0') {
					DFS(nowY,nowX);
				}
			}
		}
		
	}
}