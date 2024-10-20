import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Trie trie = new Trie(new Node());
        for(int i=0;i<n;i++){
            String string = br.readLine();
            trie.insert(string);
        }

        int answer = 0;
        for(int i=0;i<m;i++){
            String prefix = br.readLine();
            if(trie.find(prefix)){
                answer++;
            }
        }

        System.out.print(answer);
    }

    static class Trie{
        Node root;

        public Trie(Node root) {
            this.root = root;
        }

        void insert(String input){
            Node root = this.root;
            for(int i=0;i<input.length();i++){
                char c = input.charAt(i);
                if(root.child.containsKey(c)){
                    root = root.child.get(c);
                } else {
                    root.child.put(c, new Node());
                    root = root.child.get(c);
                }
            }
        }

        boolean find(String input){
            Node root = this.root;
            for(int i=0;i<input.length();i++){
                char c = input.charAt(i);
                if(root.child.containsKey(c)){
                    root = root.child.get(c);
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    static class Node{
        Map<Character, Node> child;

        Node(){
            this.child = new HashMap<>();
        }
    }
}