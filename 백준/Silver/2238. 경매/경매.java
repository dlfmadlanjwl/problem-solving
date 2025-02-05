import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Order> orders = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            orders.add(new Order(name, amount));
        }

        int[] counts = new int[u+1];
        for(Order order : orders){
            counts[order.amount]++;
        }
        int min = Integer.MAX_VALUE;
        int money = 0;
        for(int i=0;i<counts.length;i++){
            if(counts[i] < min && counts[i] != 0){
                min = counts[i];
                money = i;
            }
        }

        for(Order order : orders){
            if(order.amount == money){
                System.out.print(order.name + " " + order.amount);
                return;
            }
        }
    }

    static class Order{
        String name;
        int amount;

        Order(String name, int amount){
            this.name = name;
            this.amount = amount;
        }
    }
}