import java.util.*;

class Solution {
    public String solution(String number, int k) {
        return separate(number, k);
    }

    String separate(String number, int k) {
        if (number.length() == k) return "";

        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';
            if (n > max) {
                max = n;
                maxIdx = i;
            }
        }

        if (k < maxIdx) {
            return separate(number.substring(0, maxIdx), k) + number.substring(maxIdx);
        } else if (k > maxIdx) {
            return number.charAt(maxIdx) + separate(number.substring(maxIdx + 1), k - maxIdx);
        } else {
            return number.substring(maxIdx);
        }
    }
}