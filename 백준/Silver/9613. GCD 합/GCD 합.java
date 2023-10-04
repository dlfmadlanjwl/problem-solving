import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long sum = 0;
			for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					if(j<n) {
						sum += gcd(arr[i],arr[j]);
					}
				}
			}
			sb.append(sum+"\n");
		}
		System.out.print(sb);
	}
	public static int gcd(int a, int b) {
		if(b==0) return a;
		return gcd(b,a%b);
	}
}