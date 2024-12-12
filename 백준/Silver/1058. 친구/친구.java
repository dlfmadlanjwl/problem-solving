import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		boolean[][] check = new boolean[N+1][N+1];
		HashSet<Integer>set[] = new HashSet[N+1];
		for(int i=0;i<=N;i++) {
			set[i] = new HashSet<>();
		}
		for(int i=1;i<=N;i++) {
			String tmp = br.readLine();
			for(int j=0;j<N;j++) {
				if(tmp.charAt(j)=='Y')check[i][j+1] = true;
			}
			
		}
		
		int[] plus = new int[N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=N;k++) {
					if(j==k)continue;
					if(check[i][j]&&check[i][k]){
						if(!check[j][k]) set[j].add(k);
					}
				}
			}
		}
		
		int max = 0;
		for(int i=1;i<=N;i++) {
			int count = 0;
			for(int j=1;j<=N;j++) {
				if(check[i][j])count++;
			}
			count+=set[i].size();
			if(count>max) max = count;
		}
		System.out.print(max);
	}
}