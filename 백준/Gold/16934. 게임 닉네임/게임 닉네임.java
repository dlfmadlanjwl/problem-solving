import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            String input = br.readLine();

            sb.append(trie.insert(input)).append("\n");
        }

        System.out.print(sb);
    }

    static class Trie{
        Node root;

        Trie(){
            this.root = new Node();
        }

        String insert(String input){
            Node root = this.root;
            String nickname = "";
            for(int i=0;i<input.length();i++){
                char c = input.charAt(i);
                if(!root.child.containsKey(c)){
                    root.child.put(c, new Node());
                    root = root.child.get(c);
                    if(nickname.isBlank()) {
                        nickname = input.substring(0, i+1);
                    }
                } else {
                    root = root.child.get(c);
                }

                if(i == input.length() - 1){
                    root.count++;
                    if(nickname.isBlank()){
                        if(root.count == 1) {
                            nickname = input;
                        } else {
                            nickname = input + root.count;
                        }
                    }
                }
            }

            return nickname;
        }
    }

    static class Node{
        Map<Character, Node> child;
        int count;

        Node(){
            this.child = new HashMap<>();
            this.count = 0;
        }
    }
}