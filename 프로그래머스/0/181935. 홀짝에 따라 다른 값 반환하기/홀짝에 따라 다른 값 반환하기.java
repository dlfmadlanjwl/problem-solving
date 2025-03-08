import java.util.stream.*;

class Solution {
    public int solution(int n) {
        if(isOddNumber(n)) {
            return sumOddNumber(n);
        }
        return sumEvenNumber(n);
    }

    private static int sumOddNumber(int n){
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 != 0).sum();
    }
    
    private static int sumEvenNumber(int n){
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).map(i -> i * i).sum();
    }
    
    private static boolean isOddNumber(int n){
        return n % 2 != 0;
    }
}