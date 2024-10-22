/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
            int n = sc.nextInt();
            int[][] graph = new int[100][2];
            for(int[] arr : graph){
            	Arrays.fill(arr, -1);
            }
            for(int i=0;i<n;i++){
            	int source = sc.nextInt();
                int dest = sc.nextInt();
                if(graph[source][0] == -1){
                	graph[source][0] = dest;
                } else {
                	graph[source][1] = dest;
                }
            }
            System.out.print("#"+test_case+" ");
            if(find(graph)){
            	System.out.println(1);
            } else {
            	System.out.println(0);
            }
		}
	}
    
    static boolean find(int[][] graph){
            Queue<Integer> q = new LinkedList<>();
            boolean[] isVisited = new boolean[100];
            q.add(0);
            isVisited[0] = true;
        	while(!q.isEmpty()){
            	int now = q.poll();
                if(now == 99) return true;
                for(int i=0;i<2;i++){
                    int next = graph[now][i];
                	if(next != -1) {
                		if(isVisited[next]) continue;
                        isVisited[next] = true;
                        q.add(next);
                	}
                }
            }
            
            return false;
        }
}