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
			String input = sc.next();
            boolean[][] cards = new boolean[4][14];
            System.out.print("#"+test_case+" ");
            boolean isError = false;
            for(int i=0;i<input.length();i+=3){
            	String rawCard = input.substring(i, i+3);
                char c = rawCard.charAt(0);
                int number = Integer.parseInt(rawCard.substring(1, 3));
                if(c == 'S'){
                    if(cards[0][number]) isError = true;
                	cards[0][number] = true;
                } else if(c == 'D'){
                	if(cards[1][number]) isError = true;
                	cards[1][number] = true;
                } else if(c == 'H'){
                	if(cards[2][number]) isError = true;
                	cards[2][number] = true;
                } else if(c == 'C'){
                	if(cards[3][number]) isError = true;
                	cards[3][number] = true;
                }
            }
            if(isError){
                System.out.println("ERROR");
                continue;
            }
            for(int i=0;i<4;i++){
                int count = 0;
            	for(int j=1;j<=13;j++){
            		if(!cards[i][j]) count++;
            	}
                System.out.print(count+" ");
            }
            System.out.println();
		}
	}
}