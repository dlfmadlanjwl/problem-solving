import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int K;
	static int[] visit = new int[100001];
	static int[] arr = new int[100001];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = scan.nextInt();
		K = scan.nextInt();
		if(N==K) {
			System.out.print(0);
			return;
		}
		sb.append(bfs(N)+1);
		
		System.out.print(sb);
	}
	static int bfs(int N) {
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visit[N] = 1;
		arr[N] = 0;
		while(!q.isEmpty()) {
			
			int pop=q.poll();
			
			if(pop-1==K||pop+1==K||pop*2==K) {
				
				return arr[pop];
				
			}
			if(pop>0&&pop-1!=N) {
				if(visit[pop-1]==0&&arr[pop-1]==0) {
					q.add(pop-1);
					arr[pop-1]=arr[pop]+1;
					visit[pop-1]=1;
				}
			}
			if(pop+1<=100000&&pop+1!=N) {
				if(visit[pop+1]==0&&arr[pop+1]==0) {
					q.add(pop+1);
					arr[pop+1]=arr[pop]+1;
					visit[pop+1]=1;
				}
			}
			
			if(pop*2<=100000&&pop*2!=N) {
				if(visit[pop*2]==0&&arr[pop*2]==0) {
					q.add(pop*2);
					arr[pop*2]=arr[pop]+1;
					visit[pop*2]=1;
				}
			}
		}
		return 0;
	}
}