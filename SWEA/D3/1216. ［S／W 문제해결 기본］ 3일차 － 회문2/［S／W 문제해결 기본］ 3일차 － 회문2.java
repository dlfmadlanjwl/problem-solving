/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
        	int t = sc.nextInt();
            String[][] arr = new String[100][100];
            for(int i=0;i<100;i++){
                arr[i] = sc.next().split("");
            }
            
            int max = 0;
            for(int len=1;len<=100;len++){
            	for(int i=0;i<100;i++){
                	for(int j=0;j<100;j++){
                    	if(isPalindrome(arr, i, j, i+len-1, j)) max = len;
                        if(isPalindrome(arr, i, j, i, j+len-1)) max = len;
                    }
                }
            }
            System.out.println("#"+t+" "+max);
        }
	}
    
    static boolean isPalindrome(String[][] arr, int y1, int x1, int y2, int x2){
        if(y2 > 99 || x2 > 99) return false;
        String str = "";
    	for(int i=y1;i<=y2;i++){
        	for(int j=x1;j<=x2;j++){
            	str += arr[i][j];
            }
        }
        for(int i=0;i<str.length()/2;i++){
        	if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
}