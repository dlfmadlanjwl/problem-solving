import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] list = new String[N];
        for (int n=0;n<N;n++){
            String input = br.readLine();
            list[n] = input;
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return sum(o1)-sum(o2);
                }
                return o1.length()-o2.length();
            }
        };

        Arrays.sort(list);
        Arrays.sort(list,comparator);

        for(int i=0;i<N;i++){
            System.out.println(list[i]);
        }

    }
    static int sum(String a){
        int sum = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)>=48&&a.charAt(i)<=57){
                sum+=(int)a.charAt(i)-48;
            }
        }
        return sum;
    }
}
