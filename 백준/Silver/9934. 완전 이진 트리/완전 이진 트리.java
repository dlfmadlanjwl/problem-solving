import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    private static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(bufferedReader.readLine());
        int n = (int) Math.pow(2, k) - 1;
        int[] input = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Node node = new Node(1);
        setValue(input, node);
        for (int i = 1; i <= k; i++) {
            List<Integer> values = map.get(i);
            for (Integer value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static Map<Integer, List<Integer>> map = new HashMap<>();

    private static int index = 0;

    private static void setValue(int[] input, Node node) {
        if (node.left != null && node.left.value == null) {
            setValue(input, node.left);
        }
        if (node.value == null) {
            node.value = input[index++];
            if (!map.containsKey(node.depth)) {
                map.put(node.depth, new ArrayList<>());
            }
            map.get(node.depth).add(node.value);
        }
        if (node.right != null && node.right.value == null) {
            setValue(input, node.right);
        }
    }


    static class Node {
        Node left;
        Node right;
        int depth;
        Integer value;

        public Node(int depth) {
            this.depth = depth;
            if (depth == k) {
                return;
            }
            this.left = new Node(depth + 1);
            this.right = new Node(depth + 1);
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}