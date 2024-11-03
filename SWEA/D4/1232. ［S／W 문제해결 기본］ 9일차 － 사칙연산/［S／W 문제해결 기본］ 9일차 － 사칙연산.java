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
            Node[] nodes = new Node[n+1];
            for(int i=0;i<=n;i++){
            	nodes[i] = new Node();
            }
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
            	int number = Integer.parseInt(st.nextToken());
                String input = st.nextToken();
                nodes[number].value = input;
                if(st.hasMoreTokens()){
                	int left = Integer.parseInt(st.nextToken());
                	int right = Integer.parseInt(st.nextToken());
                    nodes[number].left = left;
                    nodes[number].right = right;
                }
            }
            
            int result = (int)find(1, nodes);
            System.out.println("#"+test_case+" "+result);
		}
	}
    
    static double find(int index, Node[] nodes){
    	Node now = nodes[index];
        if(now.value.equals("+")){
        	return find(now.left, nodes) + find(now.right, nodes);
        } else if(now.value.equals("-")){
        	return find(now.left, nodes) - find(now.right, nodes);
        } else if(now.value.equals("*")){
        	return find(now.left, nodes) * find(now.right, nodes);
        } else if(now.value.equals("/")){
        	return find(now.left, nodes) / find(now.right, nodes);
        } else {
        	return (double)Integer.parseInt(now.value);
        }
    }
    
    static class Node{
        String value;
    	int left = -1;
        int right = -1;
    }
}