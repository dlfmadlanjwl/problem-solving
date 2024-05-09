import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t=0;t<T;t++){
            String input = sc.next();
            for(int i=1;i<=30;i++){
                String subs = input.substring(0, i);
                boolean isEqual = true;
                int idx = 0;
                while(idx + i < 30){
                    if(!subs.equals(input.substring(idx, idx + i))){
                        isEqual = false;
                        break;
                    }
                    idx += i;
                }
                if(isEqual){
                    System.out.println("#"+(t+1)+" "+i);
                    break;
                }
            }
        }
    }
}