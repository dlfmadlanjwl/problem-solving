import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String x = br.readLine();
			if(x.contains("=")) {
				sb.append("skipped\n");
				continue;
			}
			String[] input = x.split("\\+");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			sb.append(a+b+"\n");
		}
		System.out.print(sb);
	}
}