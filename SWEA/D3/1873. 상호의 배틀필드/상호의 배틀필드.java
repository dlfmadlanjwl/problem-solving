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
			int h = sc.nextInt();
            int w = sc.nextInt();
            char[][] map = new char[h][w];
            
            int y = 0, x = 0;
            for(int i=0;i<h;i++){
                String input = sc.next();
            	for(int j=0;j<w;j++){
                	map[i][j] = input.charAt(j);
                    if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>'){
                    	y = i;
                        x = j;
                	}
                }
            }

            sc.next();
            String commands = sc.next();
            for(char command : commands.toCharArray()){
            	if(command == 'S'){
                	if(map[y][x] == '^'){
                    	for(int i=y;i>=0;i--){
                        	if(map[i][x] == '*'){
                            	map[i][x] = '.';
                                break;
                            }
                            if(map[i][x] == '#') break;
                        }
                    } else if(map[y][x] == 'v'){
                    	for(int i=y;i<map.length;i++){
                        	if(map[i][x] == '*'){
                            	map[i][x] = '.';
                                break;
                            }
                            if(map[i][x] == '#') break;
                        }
                    } else if(map[y][x] == '<'){
                    	for(int i=x;i>=0;i--){
                        	if(map[y][i] == '*'){
                            	map[y][i] = '.';
                                break;
                            }
                            if(map[y][i] == '#') break;
                        }
                    } else if(map[y][x] == '>'){
                    	for(int i=x;i<map[0].length;i++){
                        	if(map[y][i] == '*'){
                            	map[y][i] = '.';
                                break;
                            }
                            if(map[y][i] == '#') break;
                        }
                    }
                } else if(command == 'U'){
                	if(y-1 >= 0 && map[y-1][x] == '.'){
                    	map[y-1][x] = '^';
                        map[y][x] = '.';
                        y = y - 1;
                    } else {
                    	map[y][x] = '^';
                    }
                } else if(command == 'D'){
                	if(y+1 < map.length && map[y+1][x] == '.'){
                    	map[y+1][x] = 'v';
                        map[y][x] = '.';
                        y = y + 1;
                    } else {
                    	map[y][x] = 'v';
                    }
                } else if(command == 'L'){
                	if(x-1 >= 0 && map[y][x-1] == '.'){
                    	map[y][x-1] = '<';
                        map[y][x] = '.';
                        x = x - 1;
                    } else {
                    	map[y][x] = '<';
                    }
                } else if(command == 'R'){
                	if(x+1 < map[0].length && map[y][x+1] == '.'){
                    	map[y][x+1] = '>';
                        map[y][x] = '.';
                        x = x + 1;
                    } else {
                    	map[y][x] = '>';
                    }
                }
            }
            System.out.print("#"+test_case+" ");
            for(int i=0;i<h;i++){
            	for(int j=0;j<w;j++){
                	System.out.print(map[i][j]);
                }
                System.out.println();
            }
		}
	}
}