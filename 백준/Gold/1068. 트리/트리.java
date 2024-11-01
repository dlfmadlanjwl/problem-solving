import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer>[] nodes = new List[n];
        for(int i=0;i<nodes.length;i++){
            nodes[i] = new ArrayList<>();
        }
        int root = -1;
        for(int i=0;i<n;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1) {
                nodes[parent].add(i);
            } else {
                root = i;
            }
        }
        int c = Integer.parseInt(br.readLine());
        if(root == c) {
            System.out.print(0);
            return;
        }
        find(nodes, root, c);
        System.out.print(answer);
    }

    static void find(List<Integer>[] nodes, int index, int cut){
        List<Integer> child = nodes[index];
        int count = 0;
        for(int i=0;i<child.size();i++){
            if(child.get(i) == cut){
                continue;
            }
            count++;
            find(nodes, child.get(i), cut);
        }
        if(count == 0) answer++;
    }
}