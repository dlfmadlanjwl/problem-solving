import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] input= new int[9][9];
		int a = 0, b = 0;
		int max = 0;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
				if (input[i][j]>max) {
					max=input[i][j];
					a = i; b = j;
				}
			}
		}
		System.out.println(max);
		System.out.print((a+1)+" "+(b+1));
	}
}