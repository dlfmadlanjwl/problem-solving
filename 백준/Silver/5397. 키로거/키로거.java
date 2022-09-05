import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			Stack<Character>stack1 = new Stack<>();
			Stack<Character>stack2 = new Stack<>();
			String input = br.readLine();
			for(int i=0;i<input.length();i++) {
				char order = input.charAt(i);
				switch(order) {
					case '<':
						if(!stack1.isEmpty()) {
							stack2.add(stack1.pop());
						}
						break;
					case '>':
						if(!stack2.isEmpty()) {
							stack1.add(stack2.pop());
						}
						break;
					case '-':
						if(!stack1.isEmpty()) {
							stack1.pop();
						}
						break;
					default:
						stack1.add(order);
						break;
				}	
			}
			while(!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
			while(!stack2.isEmpty()) {
				sb.append(stack2.pop());
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}