import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			sc.nextInt();
            int[][] ladder = new int[100][100];
            boolean[][] isVisited = new boolean[100][100];
            int y = 99, x = -1;
            for(int i=0;i<100;i++){
            	for(int j=0;j<100;j++){
                	ladder[i][j] = sc.nextInt();
                    if(ladder[i][j] == 2){
                    	x = j;
                    }
                }
            }
           	
            while(y != 0){
                int[] dy = {0, 0, -1};
                int[] dx = {-1, 1, 0};
                for(int i=0;i<3;i++){
                	int newY = y + dy[i];
                    int newX = x + dx[i];
                    if(newY >= ladder.length || newY < 0 || newX >= ladder[0].length || newX < 0) continue;
                    if(isVisited[newY][newX]) continue;
                    if(ladder[newY][newX] != 1) continue;
                    y = newY;
                    x = newX;
                    isVisited[y][x] = true;
                    break;
                }
            }
            System.out.println("#"+test_case+" "+x);
		}
	}
}