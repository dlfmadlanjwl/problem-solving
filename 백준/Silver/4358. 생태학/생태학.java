import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String tree = "";
		int total = 0;
		HashMap<String,Integer>map = new HashMap<>();
		while((tree = br.readLine())!=null) {
			total++;
			if(map.containsKey(tree)) {
				map.replace(tree, map.get(tree)+1);
			}
			else map.put(tree, 1);
		}
		Object[] keys = map.keySet().toArray();
		Arrays.sort(keys);
		for(Object key : keys) {
			String keyStr = (String) key;
			int count = map.get(keyStr);
			double per = (double)(count * 100.0) / total;
			
			sb.append(keyStr+" "+String.format("%.4f", per)+"\n");
		}
		System.out.print(sb);
	}
}