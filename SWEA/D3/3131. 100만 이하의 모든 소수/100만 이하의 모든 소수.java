import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
			boolean[] isPrime = new boolean[1000001];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            
            for(int i=2;i<isPrime.length;i++){
            	if(!isPrime[i]) continue;
                for(int j=i+i;j<isPrime.length;j+=i){
                	isPrime[j] = false;
                }
            }
            
            for(int i=0;i<isPrime.length;i++){
            	if(isPrime[i]) System.out.print(i+" ");
            }
		}
}