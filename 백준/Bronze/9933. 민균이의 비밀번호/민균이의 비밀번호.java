import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String>set = new HashSet<>();
		for(int t=0;t<N;t++) {
			String input = br.readLine();
			set.add(input);
			StringBuilder sb = new StringBuilder(input);
			String copy = sb.reverse().toString(); 
			if(set.contains(copy)) {
				System.out.print(copy.length()+" "+copy.charAt(copy.length()/2));
			}
		}
	}
}