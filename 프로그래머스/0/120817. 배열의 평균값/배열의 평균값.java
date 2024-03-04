import java.util.Arrays;
import java.util.OptionalDouble;

class Solution {
    public double solution(int[] numbers) {
        OptionalDouble avg = Arrays.stream(numbers).average();
        return avg.getAsDouble();
    }
}