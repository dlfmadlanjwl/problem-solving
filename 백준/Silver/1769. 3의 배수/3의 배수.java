import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		long sum = 0;
		int count = 0;
		if(input.length()==1) {
			if(Integer.parseInt(input)%3==0) {
				System.out.print("0\nYES");
				return;
			}
			else {
				System.out.print("0\nNO");
				return;
			}
			
		}
		for(int i=0;i<input.length();i++) {
			sum+=(input.charAt(i)-'0');
		}
		count++;
		while(sum>=10) {
			String strSum = String.valueOf(sum);
			sum = 0;
			for(int i=0;i<strSum.length();i++) {
				sum+=(strSum.charAt(i)-'0');
			}
			count++;
		}
		if(sum%3==0) {
			System.out.print(count+"\n"+"YES");
		}
		else System.out.print(count+"\n"+"NO");
	}
}