import java.util.Scanner;

class Solution
{
    static boolean answer = false;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            answer = false;
			int n = sc.nextInt();
            char[][] arr = new char[n][n];
            for(int i=0;i<n;i++){
                String input = sc.next();
            	for(int j=0;j<n;j++){
                	arr[i][j] = input.charAt(j);
                }
            }
            
            for(int i=0;i<n;i++){
            	for(int j=0;j<n;j++){
                	if(arr[i][j] == 'o'){
                    	for(int d=0;d<8;d++){
                        	dfs(arr, i, j, d, 1);
                        }
                    }
                }
            }
            if(answer)System.out.println("#"+test_case+" YES");
            else System.out.println("#"+test_case+" NO");
		}
	}
    
    static void dfs(char[][] arr, int y, int x, int direction, int count){
        if(count == 5){
        	answer = true;
            return;
        }
    	int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
        int[] dx = {0, 0, 1, -1, 1, -1, -1, 1};
        
        int newY = y + dy[direction];
        int newX = x + dx[direction];
        if(newY < 0 || newX <0 || newY >= arr.length || newX >= arr[0].length) return;
        if(arr[newY][newX] != 'o') return;
        dfs(arr, newY, newX, direction, count+1);
    }
}