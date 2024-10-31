import java.util.Scanner;

class Solution
{
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] arr = new char[n][m];
            boolean hasEnd = false;
            for(int i=0;i<n;i++){
                String input = sc.next();
                for(int j=0;j<input.length();j++){
                    arr[i][j] = input.charAt(j);
                    if(arr[i][j] == '@')hasEnd = true;
                }
            }
            System.out.print("#"+test_case+" ");
			if(!hasEnd) {
                System.out.println("NO");
                continue;
            }
            boolean result = dfs(0, 0, 0, 1, arr, new boolean[n][m][4][16]);
            if(result){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static boolean dfs(int y, int x, int memory, int direction, char[][] arr, boolean[][][][] isVisited){
        if(y >= arr.length) y = 0;
        if(y < 0) y = arr.length - 1;
        if(x >= arr[0].length) x = 0;
        if(x < 0) x = arr[0].length - 1;

        if(isVisited[y][x][direction][memory]){
            return false;
        }
        isVisited[y][x][direction][memory] = true;
        boolean possible = false;
        if(arr[y][x] == '<'){
            if(dfs(y, x - 1, memory, 0, arr, isVisited)) possible = true;
        } else if(arr[y][x] == '>'){
            if(dfs(y, x + 1, memory, 1, arr, isVisited)) possible = true;
        } else if(arr[y][x] == '^'){
            if(dfs(y -1, x, memory, 2, arr, isVisited)) possible = true;
        }  else if(arr[y][x] == 'v'){
            if(dfs(y + 1, x, memory, 3, arr, isVisited)) possible = true;
        } else if(arr[y][x] == '_'){
            if(memory == 0){
                if(dfs(y, x+1, memory, 1, arr, isVisited)) possible = true;
            } else {
                if(dfs(y, x-1, memory, 0, arr, isVisited)) possible = true;
            }
        } else if(arr[y][x] == '|'){
            if(memory == 0){
                if(dfs(y + 1, x, memory, 3, arr, isVisited)) possible = true;
            } else {
                if(dfs(y - 1, x, memory, 2, arr, isVisited)) possible = true;
            }
        } else if(arr[y][x] == '?'){
            if(dfs(y, x-1, memory, 0, arr, isVisited)) possible = true;
            if(dfs(y, x+1, memory, 1, arr, isVisited)) possible = true;
            if(dfs(y - 1, x, memory, 2, arr, isVisited)) possible = true;
            if(dfs(y + 1, x, memory, 3, arr, isVisited)) possible = true;
        } else if(arr[y][x] == '.'){
            int newY = y + dy[direction];
            int newX = x + dx[direction];
            if(dfs(newY, newX, memory, direction, arr, isVisited)) possible = true;
        } else if(arr[y][x] == '@'){
            possible = true;
        } else if(arr[y][x] >= '0' && arr[y][x] <= '9'){
            int newY = y + dy[direction];
            int newX = x + dx[direction];
            if(dfs(newY, newX, arr[y][x] - '0', direction, arr, isVisited)) possible = true;
        } else if(arr[y][x] == '+'){
            int newY = y + dy[direction];
            int newX = x + dx[direction];
            if(memory == 15) {
                if(dfs(newY, newX, 0, direction, arr, isVisited)) possible = true;
            } else {
                if(dfs(newY, newX, memory + 1, direction, arr, isVisited)) possible = true;
            }
        }  else if(arr[y][x] == '-'){
            int newY = y + dy[direction];
            int newX = x + dx[direction];
            if(memory == 0) {
                if(dfs(newY, newX, 15, direction, arr, isVisited)) possible = true;
            } else {
                if(dfs(newY, newX, memory - 1, direction, arr, isVisited)) possible = true;
            }
        }
        return possible;
    }
}