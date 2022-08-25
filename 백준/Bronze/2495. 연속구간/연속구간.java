import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		while((input = br.readLine())!=null) {
			int count = 1;
			int max = 0;
			for(int i=1;i<input.length();i++) {
				if(input.charAt(i-1)==input.charAt(i)) {
					count++;
				}
				else count=1;
				if(max<count)max = count;
			}
			System.out.println(max);
		}
	}
}