import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            String result = "0";
            String[] inputs = new String[n];
            for (int j = 0; j < n; j++) {
                inputs[j] = br.readLine();
            }
            for(int j=0;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(isPalindrome(inputs[j] + inputs[k])){
                        result = inputs[j] + inputs[k];
                    }
                    if(isPalindrome(inputs[k] + inputs[j])){
                        result = inputs[k] + inputs[j];
                    }
                }
            }
            System.out.println(result);
        }
    }

    static boolean isPalindrome(String s){
        for(int i=0;i<s.length() / 2;i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}