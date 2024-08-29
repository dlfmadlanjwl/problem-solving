import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int x = 1;
        int count = 0;
        for(int i=0;i<n;i++){
            int input = Integer.parseInt(br.readLine());
            if(stack.isEmpty()){
                for(int j=x;j<=input;j++){
                    stack.push(j);
                    sb.append("+\n");
                    x++;
                }
            }
            while(!stack.isEmpty()){
                if(stack.peek() > input){
                    stack.pop();
                    sb.append("-\n");
                } else if(stack.peek() < input){
                    if(x > n) {
                        System.out.println("NO");
                        return;
                    }
                    stack.push(x);
                    sb.append("+\n");
                    x++;
                } else {
                    stack.pop();
                    sb.append("-\n");
                    count++;
                    break;
                }
            }
        }

        if(count != n)System.out.print("NO");
        else System.out.println(sb);
    }
}
