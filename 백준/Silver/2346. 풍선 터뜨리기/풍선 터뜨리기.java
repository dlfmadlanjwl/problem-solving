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
        Deque<Balloon> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            deque.add(new Balloon((i+1), Integer.parseInt(st.nextToken())));
        }

        Balloon now = deque.pop();
        sb.append(now.num+" ");
        while(!deque.isEmpty()){
            int move = now.move;
            if(move > 0){
                for(int i=0;i<move-1;i++){
                    deque.addLast(deque.removeFirst());
                }
                now = deque.removeFirst();
                sb.append(now.num+" ");
            } else {
                for(int i=0;i<-move;i++){
                    deque.addFirst(deque.removeLast());
                }
                now = deque.removeFirst();
                sb.append(now.num+" ");
            }
        }
        System.out.print(sb);
    }

    static class Balloon{
        int num;
        int move;
        Balloon(int num, int move){
            this.num = num;
            this.move = move;
        }
    }
}

