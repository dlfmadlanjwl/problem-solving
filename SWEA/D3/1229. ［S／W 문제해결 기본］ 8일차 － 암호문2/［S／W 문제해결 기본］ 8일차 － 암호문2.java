import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            List<Integer> list = new ArrayList<>();
        	int cipherLen = sc.nextInt();
            for(int i=0;i<cipherLen;i++){
            	list.add(sc.nextInt());
            }
            int operationLen = sc.nextInt();
            for(int i=0;i<operationLen;i++){
            	String op = sc.next();
                if(op.equals("I")){
                	int index = sc.nextInt();
                	int itemCount = sc.nextInt();
                	int[] items = new int[itemCount];
                	for(int j=0;j<itemCount;j++){
                		items[j] = sc.nextInt();
                    }
                    insert(index, items, list);
                } else if(op.equals("D")){
                	int index = sc.nextInt();
                    int count = sc.nextInt();
                    delete(index, count, list);
                }
            }   
            System.out.print("#"+test_case+" ");
            for(int i=0;i<10;i++){
            	System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
	}
    static void insert(int index, int[] items, List<Integer>list){
    	for(int i=0; i<items.length; i++){
        	list.add(i + index, items[i]);
        }
    }
    static void delete(int index, int count, List<Integer>list){
       	for(int i=0;i<count;i++){
        	list.remove(index);
        }
    }
}