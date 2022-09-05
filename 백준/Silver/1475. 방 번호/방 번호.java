import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int[] num = new int[10];
		for(int i=0;i<input.length();i++) {
			num[input.charAt(i)-'0']++;
		}
		if((num[6]+num[9])%2==0) {
			num[6] = (num[6]+num[9])/2;
		}
		else num[6] = (num[6]+num[9])/2+1;
		int max = 0;
		for(int i=0;i<9;i++) {
			if(max<num[i]) {
				max = num[i];
			}
		}
		System.out.print(max);
	}
}