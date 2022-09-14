import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Boolean>map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		for(int t=0;t<n;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String inOut = st.nextToken();
			if(inOut.equals("enter")) {
				map.put(name, true);
			}
			else map.remove(name);
		}
		ArrayList<String>arr= new ArrayList<>(map.keySet());
		Collections.sort(arr,Collections.reverseOrder());
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}
}