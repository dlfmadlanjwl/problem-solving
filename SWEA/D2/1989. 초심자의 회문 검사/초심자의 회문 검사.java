import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t=0;t<T;t++){
            String input = sc.next();
            int result = 1;
            for(int i=0; i < input.length()/2; i++){
                if(input.charAt(i) != input.charAt(input.length()-1-i)){
                    result = 0;
                    break;
                }
            }
            System.out.println("#"+(t+1)+" "+result);
        }
    }
}