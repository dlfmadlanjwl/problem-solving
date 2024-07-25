class Solution {
    public long solution(int w, int h) {
        long total = (long)w * (long)h;
        long gcd = gcd((long)w, (long)h);
        long unitW = w / gcd;
        long unitH = h / gcd;
        
        long broken = gcd * (unitW + unitH - 1);
        return total - broken; 
    }
    
    long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}