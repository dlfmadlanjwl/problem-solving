import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
        	sc.nextInt();
            Queue<Integer> q = new LinkedList<>();
            for(int i=0;i<8;i++){
            	q.add(sc.nextInt());
            }
            
            int n = 1;
            while(true){
                if(n>5) n=1;
            	int x = q.poll();
                if(x - n <= 0) {
                    q.add(0);
                    break;
                }
                q.add(x - n);
                n++;
            }
            System.out.print("#"+test_case+" ");
            for(int i=0;i<8;i++){
            	System.out.print(q.poll()+" ");
            }
            System.out.println();
        }
	}
}