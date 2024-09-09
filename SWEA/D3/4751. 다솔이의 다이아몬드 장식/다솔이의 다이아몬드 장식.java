import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            char[] input = sc.next().toCharArray();
			char[][] arr = new char[5][input.length * 4 + 1];
            for(char[] i : arr){
            	Arrays.fill(i, '.');
            }
            
            for(int i=0;i<arr[0].length;i++){
            	if(i % 4 == 2){
                    arr[0][i] = '#';
                    arr[2][i] = input[i/4];
                    arr[4][i] = '#';
                }
                if(i % 2 == 1) {
                    arr[1][i] = '#';
                    arr[3][i] = '#';
                }
                if(i % 4 == 0) arr[2][i] = '#';
            }
            
            for(int i=0;i<arr.length;i++){
            	for(int j=0;j<arr[0].length;j++){
                	System.out.print(arr[i][j]);
                }
                System.out.println();
            }
		}
	}
}