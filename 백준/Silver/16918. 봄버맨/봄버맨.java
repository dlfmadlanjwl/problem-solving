import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] graph;
	static int R,C,N;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new int[R][C];
		int[] changeX = {0,0,-1,1};
		int[] changeY = {1,-1,0,0};
		for(int i=0;i<R;i++) {
			String input = br.readLine();
			for(int j=0;j<C;j++) {
				if(input.charAt(j)=='O') {
					graph[i][j] = 3;
				}
			}
		}
		if(N>=1) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(graph[i][j]==3)graph[i][j]--;
				}
			}
		}
		for(int k=2;k<=N;k++) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(graph[i][j]==1) {
						for(int l=0;l<4;l++) {
							int nowY = i+changeY[l];
							int nowX = j+changeX[l];
							if(nowY>=0&&nowY<R&&nowX>=0&&nowX<C) {
								if(graph[nowY][nowX]!=1)graph[nowY][nowX]=-1;
							}
						}
						graph[i][j]=-1;
					}
				}
			}
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(graph[i][j]==0)graph[i][j]=3;
					else if(graph[i][j]>0)graph[i][j]--;
					else graph[i][j]=0;
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(graph[i][j]==0) {
					System.out.print(".");
				}
				else System.out.print("O");
			}
			System.out.println();
		}
	}
}