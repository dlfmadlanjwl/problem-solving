import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true){
            String input = br.readLine();
            if(input == null) break;

            int n = Integer.parseInt(input);

            Node next = root;
            while(true){
                if(n < next.value){
                    if(next.left == null){
                        next.left = new Node(n);
                        break;
                    } else {
                        next = next.left;
                    }
                } else {
                    if(next.right == null){
                        next.right = new Node(n);
                        break;
                    } else {
                        next = next.right;
                    }
                }
            }
        }

        backSearch(root);
    }

    static void backSearch(Node root){
        if(root.left != null) backSearch(root.left);
        if(root.right != null) backSearch(root.right);
        System.out.println(root.value);
    }

    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }
}