import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(char c : a.toCharArray()){
            if(c >= 'a' && c <= 'z'){
                System.out.print((char)(c - ('a' - 'A')));
            } else {
                System.out.print((char)(c + ('a' - 'A')));
            }
        }
    }
}