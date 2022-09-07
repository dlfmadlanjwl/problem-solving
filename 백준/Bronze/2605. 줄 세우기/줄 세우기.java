import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = 2;
		ArrayList<Integer>arr = new ArrayList<>();
		int tmp1 = Integer.parseInt(st.nextToken());
		arr.add(1);
		for(int i=2;i<=N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr.add(arr.size()-tmp,num);
			num++;
		}
		for(int i=0;i<N;i++) {
			System.out.print(arr.get(i)+" ");
		}
	}
}