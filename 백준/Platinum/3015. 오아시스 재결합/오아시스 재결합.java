import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Person> stack = new Stack<>();
        long pairCount = 0;
        for(int i=0;i<n;i++){
            int height = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peek().height < height){
                pairCount += stack.pop().count;
            }

            if(stack.isEmpty()){
                stack.add(new Person(height, 1));
                continue;
            }

            Person top = stack.peek();
            if(top.height == height){
                pairCount += top.count;
                if(stack.size() > 1) pairCount++;
                stack.peek().count++;
            } else if (top.height > height){
                stack.add(new Person(height, 1));
                pairCount++;
            }
        }

        System.out.print(pairCount);
    }

    static class Person {
        int height;
        int count;

        Person(int height, int count){
            this.height = height;
            this.count = count;
        }
    }
}
