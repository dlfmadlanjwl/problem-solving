import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static int N,M;
	static int arr[];
	static int result[];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		N = scan.nextInt(); M = scan.nextInt();
		arr = new int[N+1];
		for(int i=1;i<=N;i++) arr[i] = scan.nextInt();
		result = new int[M+1];
		Arrays.sort(arr);
		dfs(1);
	}
	static void dfs(int idx){
		if(idx==M+1) {
			for(int i=1;i<result.length;i++) {
				System.out.print(result[i]+" ");
			}
			System.out.println();
		}
		else {
			for(int i=1;i<=N;i++) {
				if(arr[i]>=result[idx-1]) {
					result[idx] = arr[i];
					dfs(idx+1);
				}
			}
		}
	}
}