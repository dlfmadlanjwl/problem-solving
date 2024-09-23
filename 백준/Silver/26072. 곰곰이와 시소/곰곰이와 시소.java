import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] positions = new int[n];
        int[] weights = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            positions[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            weights[i] = Integer.parseInt(st.nextToken());
        }

        double answer = binarySearch(0, l, positions, weights);
        System.out.print(answer);
    }

    static double binarySearch(double left, double right, int[] positions, int[] weights){
        while(left + Math.pow(10, -7) < right){
            double mid = (left + right) / 2;

            double leftWeight = 0;
            double rightWeight = 0;
            for(int i=0;i<positions.length;i++){
                if(positions[i] > mid){
                    rightWeight += (positions[i] - mid) * weights[i];
                } else if (positions[i] < mid){
                    leftWeight += (mid - positions[i]) * weights[i];
                }
            }

            if(leftWeight > rightWeight){
                right = mid;
            } else if(leftWeight < rightWeight){
                left = mid;
            } else {
                return mid;
            }
        }

        return right;
    }
}