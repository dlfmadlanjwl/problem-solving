import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[][] arr1 = new int[300][300];
            Node[] arr2 = new Node[200001];

            int y = 1;
            int x = 1;
            int value = 1;
            while(true){
                if(y == 300 || x == 300) break;
                if(y < 1) {
                    y = x;
                    x = 1;
                }
                arr1[y][x] = value;
                arr2[value] = new Node(y, x);
                value++;
                y--;
                x++;
            }

            Node node1 = arr2[p];
            Node node2 = arr2[q];
            int result = arr1[node1.y + node2.y][node1.x + node2.x];
            System.out.println("#"+test_case+" "+result);
        }
    }

    static class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
