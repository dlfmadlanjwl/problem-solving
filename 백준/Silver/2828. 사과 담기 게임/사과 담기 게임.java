import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int J = Integer.parseInt(br.readLine());
		int Start = 1;
		int End = M;
		int count = 0;
		for(int i=0;i<J;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x>End) {
				int tmp = x-End;
				count += tmp;
				End += tmp;
				Start += tmp;
			}
			else if(x<Start) {
				int tmp = Start-x;
				count += tmp;
				End -= tmp;
				Start -= tmp;
			}
		}
		System.out.print(count);
	}
}