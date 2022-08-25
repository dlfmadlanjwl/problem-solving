import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static char[] arr;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t=0;t<T;t++) {
			String input = br.readLine();
			arr = input.toCharArray();
			int left=0;
			int right=input.length()-1;
			if(check(left,right)) {
				System.out.println(0);
			}
			else if(check1(left,right)) {
				System.out.println(1);
			}
			else {
				System.out.println(2);
			}
		}
	}
	
	static boolean check(int left,int right) {
		while(left<=right) {
			if(arr[left]!=arr[right]) {
				return false;
			}
			left+=1;
			right-=1;
		}
		return true;
	}
	static boolean check1(int left,int right) {
		while(left<=right) {
			if(arr[left]!=arr[right]) {
				boolean a=check(left+1,right);
				boolean b=check(left,right-1);
				if(a==false && b==false) {
					return false;
				}else return true;
			}
			left+=1;
			right-=1;
		}
		return true;
	}
}