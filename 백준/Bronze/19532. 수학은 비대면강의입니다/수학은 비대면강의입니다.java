import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] input = new int[6];
        for(int i=0;i<6;i++){
            input[i] = sc.nextInt();
        }

        int a = 0, b = 0;
        for(int i=-999;i<=999;i++){
            for(int j=-999;j<=999;j++){
                if(input[0] * i + input[1] * j == input[2]){
                    if(input[3] * i + input[4] * j == input[5]) {
                        a = i;
                        b = j;
                    }
                }
            }
        }
        System.out.print(a+" "+b);
    }
}