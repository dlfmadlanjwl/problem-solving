import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[] days = new int[7];
            for(int i=0;i<7;i++){
            	int isOpen = sc.nextInt();
                days[i] = isOpen;
            }
            int answer = Integer.MAX_VALUE;
            for(int start=0;start<7;start++){
                if(days[start] == 1) answer = Math.min(answer, cal(days, start, n));
            }
            System.out.println("#"+test_case+" "+answer);
		}
	}
    
    static int cal(int[] days, int start, int n){
        int answer = 0;
        int index = start;
        while(true){
            answer++;
            if(index == 7) index = 0;
            if(days[index] == 1){
                n--;
            }
            if(n == 0){
				return answer;
            }
            index++;
        }   
    }
}