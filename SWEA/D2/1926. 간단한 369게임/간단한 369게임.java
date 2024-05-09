import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            int x = i;
            int count = 0;
            while(x>0){
                if(x % 10 == 3 || x % 10 == 6 || x % 10 == 9) count++;
                x /= 10;
            }
            if(count > 0){
                for(int j=0;j<count;j++) System.out.print('-');
            }else{
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}