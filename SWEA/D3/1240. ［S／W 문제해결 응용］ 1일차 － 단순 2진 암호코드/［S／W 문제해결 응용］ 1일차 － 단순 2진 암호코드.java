import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int height = sc.nextInt();
            int width = sc.nextInt();
            String[] cipher = new String[8];
            String[] inputs = new String[height];
            for(int i=0;i<height;i++){
                inputs[i] = sc.next();
            }
            for(int i=0;i<height;i++){
                String input = inputs[i];
                if(input.contains("1")){
                    int lastOneIndex = 0;
                    for(int j=input.length()-1;j>0;j--){
                        if(input.charAt(j)=='1') {
                            lastOneIndex = j;
                            break;
                        }
                    }
                    int index = 0;
                    for(int j=lastOneIndex-55;j<=lastOneIndex;j+=7){
                        cipher[index] = input.substring(j, j+7);
                        index++;
                    }
                    break;
                }
            }
            int sum = 0;
            int isValid = sum;
            for(int i=0;i<8;i++){
                int number = 0;
                if(cipher[i].equals("0001101")) number = 0;
                else if(cipher[i].equals("0011001")) number = 1;
                else if(cipher[i].equals("0010011")) number = 2;
                else if(cipher[i].equals("0111101")) number = 3;
                else if(cipher[i].equals("0100011")) number = 4;
                else if(cipher[i].equals("0110001")) number = 5;
                else if(cipher[i].equals("0101111")) number = 6;
                else if(cipher[i].equals("0111011")) number = 7;
                else if(cipher[i].equals("0110111")) number = 8;
                else if(cipher[i].equals("0001011")) number = 9;
                if((i+1)%2==0) {
                    isValid += number;
                }else{
                    isValid += number * 3;
                }
                sum += number;
            }
            if(isValid % 10 == 0){
                System.out.println("#"+test_case+" "+sum);
            }else{
                System.out.println("#"+test_case+" 0");
            }
        }
    }
}