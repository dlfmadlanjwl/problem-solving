import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Problem> list = new ArrayList<>();
        for(int i=0;i<8;i++){
            list.add(new Problem(i+1, Integer.parseInt(br.readLine())));
        }

        Collections.sort(list);
        int sum = 0;
        for(int i=0;i<5;i++){
            sum += list.get(i).score;
        }

        System.out.println(sum);
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<5;i++){
            numbers.add(list.get(i).number);
        }

        Collections.sort(numbers);
        for(int i=0;i<numbers.size();i++){
            System.out.print(numbers.get(i)+" ");
        }
    }

    static class Problem implements Comparable<Problem>{
        int number;
        int score;

        public Problem(int number, int score) {
            this.number = number;
            this.score = score;
        }

        @Override
        public int compareTo(Problem p) {
            return p.score - this.score;
        }
    }
}