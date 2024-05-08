import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private static class Node{
        int value;
        int x;
        int y;
        Node left;
        Node right;

        private Node(int value, int x, int y){
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    private Node constructNode(Node[] nodes){
        Node root = nodes[0];

        for(int i=1;i<nodes.length;i++){
            insert(root, nodes[i]);
        }

        return root;
    }

    private void insert(Node root, Node node){
        if(node.x < root.x){
            if(root.left == null){
                root.left = node;
            } else insert(root.left, node);
        } else{
            if(root.right == null){
                root.right = node;
            } else insert(root.right, node);
        }
    }

    private void pre(Node node, List<Integer> visits){
        if(node == null) return;

        visits.add(node.value);
        pre(node.left, visits);
        pre(node.right, visits);
    }

    private void post(Node node, List<Integer> visits){
        if(node == null) return;

        post(node.left, visits);
        post(node.right, visits);
        visits.add(node.value);
    }

    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for(int i=0;i<nodeinfo.length;i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, (a,b)->b.y - a.y);

        Node root = constructNode(nodes);

        List<Integer> preorder = new ArrayList<>();
        pre(root, preorder);

        List<Integer> postorder = new ArrayList<>();
        post(root, postorder);

        return new int[][]{
                preorder.stream().mapToInt(Integer::intValue).toArray(),
                postorder.stream().mapToInt(Integer::intValue).toArray()
        };
    }
}