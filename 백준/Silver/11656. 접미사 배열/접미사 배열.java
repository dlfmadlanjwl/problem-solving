import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<String> list = new ArrayList<>();
        String str = "";
        for (int i=input.length()-1;i>=0;i--){
            str = input.charAt(i)+str;
            list.add(str);
        }
        Collections.sort(list);
        list.stream().forEach(x->System.out.println(x));
    }
}