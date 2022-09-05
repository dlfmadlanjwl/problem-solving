import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character>stack = new Stack<>();
		String input = br.readLine();
		int value = 1;
		int result = 0;
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)=='(') {
				value*=2;
				stack.add('(');
			}
			else if(input.charAt(i)=='[') {
				value*=3;
				stack.add('[');
			}
			else if(input.charAt(i)==')') {
				if(stack.isEmpty()||stack.peek()!='(') {
					result = 0;
					break;
				}
				else if(input.charAt(i-1)=='(') {
					result+=value;					
				}
				stack.pop();
				value/=2;
			}
			else if(input.charAt(i)==']') {
				if(stack.isEmpty()||stack.peek()!='[') {
					result = 0;
					break;
				}
				else if(input.charAt(i-1)=='[') {
					result+=value;					
				}
				stack.pop();
				value/=3;
			}
		}
		if(!stack.isEmpty()) {
			System.out.print(0);
		}
		else System.out.print(result);
	}
}