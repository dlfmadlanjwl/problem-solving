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
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
            	int number = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);
                nodes[number] = new Node(c);
                if(st.hasMoreTokens()){
                	int left = Integer.parseInt(st.nextToken());
                    nodes[number].left = left;
                }
                if(st.hasMoreTokens()){
                	int right = Integer.parseInt(st.nextToken());
                    nodes[number].right = right;
                }
            }
            System.out.print("#"+test_case+" ");
           	find(nodes, 1);
            System.out.println();
		}
	}
    
    static void find(Node[] nodes, int now){
    	Node nowNode = nodes[now];
        if(nowNode.left != 0) find(nodes, nowNode.left);
        System.out.print(nowNode.value);
        if(nowNode.right != 0) find(nodes, nowNode.right);
    }
    
    static class Node{
        char value;
    	int left = 0;
        int right = 0;
     	Node(char value){
        	this.value = value;
        }
    }
}