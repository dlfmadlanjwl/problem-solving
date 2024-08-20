import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for(int i=0;i<n;i++){
            input[i] = sc.nextInt();
        }
        List<Integer> lis = new ArrayList<>();
        lis.add(input[0]);
        for(int i=1;i<input.length;i++){
            if(input[i] > lis.get(lis.size()-1)){
                lis.add(input[i]);
            } else if(input[i] < lis.get(lis.size()-1)){
                int index = binarySearch(lis, input[i]);
                lis.set(index, input[i]);
            }
        }
        System.out.println(lis.size());
    }

    static int binarySearch(List<Integer> lis, int value){
        int left = 0, right = lis.size()-1;

        while(left < right){
            int mid = (left + right) / 2;
            if(lis.get(mid) < value){
                left = mid+1;
            } else if(lis.get(mid) > value){
                right = mid;
            } else {
                return mid;
            }
        }
        return left;
    }
}
