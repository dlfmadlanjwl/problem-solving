import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            long[] yArr = new long[n], xArr = new long[n];
            for(int i=0;i<n;i++){
            	yArr[i] = sc.nextLong();
            }
            for(int i=0;i<n;i++){
            	xArr[i] = sc.nextLong();
            }
            double rate = sc.nextDouble();
            List<Edge> edges = new ArrayList<>();
            for(int i=0;i<n;i++){
            	for(int j=i+1;j<n;j++){
                	long yDiff = yArr[i] - yArr[j];
                    long xDiff = xArr[i] - xArr[j];
                    double length = Math.sqrt(Math.pow(yDiff, 2) + Math.pow(xDiff, 2));
                    edges.add(new Edge(i, j, length));
                }
            }
            
            long result = (long)Math.round(kruskal(edges, n) * rate);
            System.out.println("#"+test_case+" "+result);
		}
	}
    static double kruskal(List<Edge> edges, int n){        
    	edges.sort(new Comparator<Edge>(){
            public int compare(Edge a, Edge b){
                if(a.length > b.length) return 1;
                else if(a.length == b.length) return 0;
                else return -1;
            }
        });
        int[] parents = new int[n];
        for(int i=0;i<n;i++){
        	parents[i] = i;
        }
        double sum = 0;
        int count = 0;
        for(int i=0;i<edges.size();i++){
            Edge edge = edges.get(i);
        	int parentA = find(edge.source, parents);
            int parentB = find(edge.dest, parents);
            if(parentA == parentB) continue;
            if(parentA < parentB) parents[parentB] = parentA;
            else  parents[parentA] = parentB;
            count++;
            sum += Math.pow(edge.length,2);
            if(count == n) break;
        }
        
        return sum;
    }
    
    static int find(int child, int[] parents){
    	if(parents[child] == child) return child;
        return find(parents[child], parents);
    }
    
    static class Edge{
    	int source;
        int dest;
        double length;
        
        Edge(int source, int dest, double length){
        	this.source = source;
            this.dest = dest;
            this.length = length;
        }
    }
}