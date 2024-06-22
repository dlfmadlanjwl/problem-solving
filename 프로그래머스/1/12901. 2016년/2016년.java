class Solution {
    public String solution(int a, int b) {
        String[] dayOfWeek = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int day = b;
        for(int i=1;i<a;i++){
            day += days[i-1];
        }
        
        return dayOfWeek[(4 + day) % 7];
    }
}