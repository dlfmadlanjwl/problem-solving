import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int t=0;t<N;t++) {
			String[] input = br.readLine().split(" ");
 			Stack<String>stack = new Stack<>();
			for(int i=0;i<input.length;i++) {
				stack.add(input[i]);
			}
			sb.append("Case #"+(t+1)+": ");
			while(!stack.isEmpty()) {
				sb.append(stack.pop()+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}