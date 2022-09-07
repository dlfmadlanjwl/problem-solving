import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static int[] parent;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==1) {
					union(i,j);
				}
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr =new int[M];
		for(int i=0;i<M;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<M-1;i++) {
			if(find(arr[i])!=find(arr[i+1])) {
				System.out.print("NO");
				System.exit(0);
			}
		}
		System.out.print("YES");
	}
	public static int find(int x) {
		if(x==parent[x]) {
			return x;
		}
		return find(parent[x]);
	}
	public static void union(int x,int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) {
			parent[y] = x;
		}
		else if(x>y) {
			parent[x] = y;
		}
	}
}