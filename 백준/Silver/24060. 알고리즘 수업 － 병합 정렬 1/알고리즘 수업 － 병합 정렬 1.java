import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int cnt = 0;
	static int[] A,tmp; 
	static int k;
	static void merge_sort(int p,int r) { 
	    if (p < r) {
	        int q = (p + r) / 2;     
	        merge_sort(p, q); 
	        merge_sort(q + 1, r);
	        merge(p, q, r);      
	    }
	}

	static void merge(int p, int q, int r) {
	    int i = p, j = q + 1, t = p;
	    while (i <= q && j <= r) {
	        if (A[i] <= A[j]) {
	        	tmp[t++] = A[i++];
	        }
	        else {
	        	tmp[t++] = A[j++];
	        }
	    }
	    while (i <= q)  
	        tmp[t++] = A[i++];
	    while (j <= r)  
	        tmp[t++] = A[j++]; 
	    i = p; t=p;
	    while (i <= r) {
	    	A[i++] = tmp[t++];
	    	cnt++;
	    	if(cnt == k) {
	    		System.out.println(A[i-1]);
	    	}
	    }
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		A = new int[N];
		tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		merge_sort(0,N-1);
		if(cnt<k) {
			System.out.print(-1);
		}
	}
}
