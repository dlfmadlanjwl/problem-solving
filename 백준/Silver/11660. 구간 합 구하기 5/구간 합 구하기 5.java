import java.util.Scanner;

public class Main{
	static int alphabet[][];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = scan.nextInt();
		int M = scan.nextInt();
		int arr[][] = new int[N+1][N+1];
		int sum[][] = new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				arr[i][j] = scan.nextInt();
				if(j==1) sum[i][j]=arr[i][j];
				else sum[i][j] = sum[i][j-1]+arr[i][j];
			}
		}
		for(int t=0;t<M;t++) {
			int y1 = scan.nextInt();
			int x1 = scan.nextInt();
			int y2 = scan.nextInt();
			int x2 = scan.nextInt();
			int result=0;
			for(int i=y1;i<=y2;i++) {
				if(x1==1) {
					result+=sum[i][x2];
				}
				else result+=(sum[i][x2]-sum[i][x1-1]);
			}
			sb.append(result+"\n");
		}
		
		
		System.out.println(sb);
	}
}
