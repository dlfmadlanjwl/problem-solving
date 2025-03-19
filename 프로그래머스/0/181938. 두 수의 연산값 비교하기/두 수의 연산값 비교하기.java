class Solution {
    public int solution(int a, int b) {
        return Math.max(a * b * 2, Integer.parseInt(String.valueOf(a) + String.valueOf(b)));
    }
}