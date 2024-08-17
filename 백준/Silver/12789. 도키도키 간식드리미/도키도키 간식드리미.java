import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for(int i=n-1;i>=0;i--){
            stack1.add(input[i]);
        }

        int seq = 1;
        while(!(stack1.isEmpty() && stack2.isEmpty())){
            if(!stack1.isEmpty() && stack1.peek() == seq){
                stack1.pop();
                seq++;
            }else if(!stack2.isEmpty() && stack2.peek() == seq){
                stack2.pop();
                seq++;
            } else{
                stack2.add(stack1.pop());
            }
            if(stack1.isEmpty() && !stack2.isEmpty()){
                if(stack2.peek() != seq) break;
            }
        }
        if(seq == n+1) System.out.println("Nice");
        else System.out.println("Sad");
    }
}

