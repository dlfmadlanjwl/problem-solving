import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, L, R;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int date = -1;
        while(true){
            date++;
            boolean isChanged = false;
            boolean[][] isVisited = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!isVisited[i][j]){
                        List<Node> list = new ArrayList<>();
                        list.add(new Node(i,j));
                        isVisited[i][j] = true;
                        bfs(list, isVisited, arr, i, j);
                        if (list.size() > 1) isChanged = true;
                        setToAverage(list, arr);
                    }
                }
            }
            if(!isChanged) break;
        }
        System.out.print(date);
    }
    private static void bfs(List<Node> list, boolean[][] isVisited, int[][] arr, int y, int x){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x));
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        while(!q.isEmpty()){
            Node currentNode = q.poll();
            for(int i=0;i<4;i++){
                int newY = currentNode.y + dy[i];
                int newX = currentNode.x + dx[i];
                if(newY >= 0 && newY < isVisited.length && newX >= 0 && newX < isVisited[0].length){
                    int diff = Math.abs(arr[newY][newX] - arr[currentNode.y][currentNode.x]);
                    if(!isVisited[newY][newX] && diff >= L && diff <= R ){
                        list.add(new Node(newY, newX));
                        isVisited[newY][newX] = true;
                        q.add(new Node(newY, newX));
                    }
                }
            }
        }
    }
    private static void setToAverage(List<Node> list, int[][] arr){
        int sum = 0;
        for(Node n : list){
            sum += arr[n.y][n.x];
        }
        for(Node n : list){
            arr[n.y][n.x] = sum / list.size();
        }
    }
    private static class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
