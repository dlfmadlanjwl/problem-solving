import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case = 1; test_case <= 10; test_case++)
		{
         	int n = Integer.parseInt(br.readLine());
            boolean check = true;
            for(int i=0;i<n;i++){
            	StringTokenizer st = new StringTokenizer(br.readLine());
                int number = Integer.parseInt(st.nextToken());
               	String value = st.nextToken();
                if(st.hasMoreTokens()){
                	st.nextToken();
                    if(!(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"))){
                    	check = false;
                    }
                } else {
                	if(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")){
                    	check = false;
                    }
                }
                if(st.hasMoreTokens()){
                	st.nextToken();
                }
            }
            if(check){
            	System.out.println("#"+test_case+" "+1);
            } else {
            	System.out.println("#"+test_case+" "+0);
            }
		}
	}
}