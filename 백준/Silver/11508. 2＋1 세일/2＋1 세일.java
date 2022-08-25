import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] input= new Integer[N];
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		long sum=0;
		Arrays.sort(input,Collections.reverseOrder());
		for(int i=0;i<N;i++) {
			if(i%3!=2) {
				sum+=input[i];
			}
		}
		System.out.print(sum);
	}
}