import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = new int[5];
		int sum = 0;
		for(int i=0;i<5;i++) {
			input[i] = Integer.parseInt(br.readLine());
			sum += input[i];
		}
		Arrays.sort(input);
		System.out.print(sum/5+"\n"+input[2]);
	}
}