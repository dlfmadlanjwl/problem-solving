import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while(n!=-1){
            List<Integer> list = new ArrayList<>();
            for(int i=1;i<=Math.sqrt((double) n);i++){
                if(n%i==0){
                    if(i==n/i||i==1){
                        list.add(i);
                        continue;
                    }
                    list.add(i);
                    list.add(n/i);
                }
            }
            Collections.sort(list);
            int sum = list.stream().mapToInt(Integer::intValue).sum();
            if(n==sum){
                System.out.print(n+" = ");
                for(int i=0;i<list.size()-1;i++){
                    System.out.print(list.get(i)+" + ");
                }
                System.out.println(list.get(list.size()-1));
            }else{
                System.out.println(n+" is NOT perfect.");
            }
            n = Integer.parseInt(br.readLine());
        }
    }
}