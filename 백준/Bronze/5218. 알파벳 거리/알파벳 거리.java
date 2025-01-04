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
			sb.append("Distances: ");
			String A = st.nextToken();
			String B = st.nextToken();
			for(int i=0;i<A.length();i++) {
				if(A.charAt(i)<=B.charAt(i)) {
					sb.append(B.charAt(i)-A.charAt(i)+" ");
				}
				else sb.append(B.charAt(i)+26-A.charAt(i)+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}