import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		HashSet<Integer> set = new HashSet<>();
		int N = scan.nextInt();
		for(int i=0;i<N;i++) {
			String order = scan.next();
			if(order.equals("add")) {
				int tmp = scan.nextInt();
				set.add(tmp);
			}
			else if(order.equals("check")) {
				int tmp = scan.nextInt();
				if(set.contains(tmp)) sb.append(1+"\n");
				else sb.append(0+"\n");
			}
			else if(order.equals("remove")) {
				int tmp = scan.nextInt();
				set.remove(tmp);
			}
			else if(order.equals("toggle")) {
				int tmp = scan.nextInt();
				if(set.contains(tmp)) set.remove(tmp);
				else set.add(tmp);
			}
			else if(order.equals("all")) {
				
				for(int j=0;j<20;j++) {
					set.add(j+1);
				}
			}
			else if(order.equals("empty")) {
				set.clear();
			}
		}
		System.out.print(sb);
	}
}