class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if (">=".equals(ineq + eq)) {
            return n >= m ? 1 : 0;
        }
        if ("<=".equals(ineq + eq)) {
            return n <= m ? 1 : 0;
        }
        if (">!".equals(ineq + eq)) {
            return n > m ? 1 : 0;
        }
        if ("<!".equals(ineq + eq)) {
            return n < m ? 1 : 0;
        }
        return 1;
    }
}