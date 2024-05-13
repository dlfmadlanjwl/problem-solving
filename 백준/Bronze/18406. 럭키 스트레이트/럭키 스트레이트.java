import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0;i<input.length()/2;i++) {
			sum1 += input.charAt(i)-'0';
		}
		for(int i=input.length()/2;i<input.length();i++) {
			sum2 += input.charAt(i)-'0';
		}
		if(sum2==sum1) {
			System.out.print("LUCKY");
		}
		else System.out.print("READY");
		
	}
}