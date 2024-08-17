import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int value;
            switch (command){
                case 1:
                    value = Integer.parseInt(st.nextToken());
                    deque.addFirst(value);
                    break;
                case 2:
                    value = Integer.parseInt(st.nextToken());
                    deque.addLast(value);
                    break;
                case 3:
                    if(deque.isEmpty()) sb.append(-1+"\n");
                    else sb.append(deque.pop()+"\n");
                    break;
                case 4:
                    if(deque.isEmpty()) sb.append(-1+"\n");
                    else sb.append(deque.removeLast()+"\n");
                    break;
                case 5:
                    sb.append(deque.size()+"\n");
                    break;
                case 6:
                    if(deque.isEmpty()) sb.append(1+"\n");
                    else sb.append(0+"\n");
                    break;
                case 7:
                    if(deque.isEmpty()) sb.append(-1+"\n");
                    else sb.append(deque.peek()+"\n");
                    break;
                case 8:
                    if(deque.isEmpty()) sb.append(-1+"\n");
                    else sb.append(deque.peekLast()+"\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}

