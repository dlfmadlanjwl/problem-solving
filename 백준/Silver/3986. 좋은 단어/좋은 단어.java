import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i=0;i<N;i++) {
			Stack<Character>stack = new Stack<>();
			String input = br.readLine();
			for(int j=0;j<input.length();j++) {
				char tmp = input.charAt(j);
				if(!stack.isEmpty()) {
					if(stack.peek()==tmp) {
						stack.pop();
					}
					else stack.add(tmp);
				}
				else stack.add(tmp);
			}
			if(stack.isEmpty())count++;
		}
		System.out.print(count);
	}
}