class Solution {
    public int solution(int n) {
        int goal = getCount(n);

        while(true){
            n++;
            int count = getCount(n);
            if(count == goal) return n;
        }
    }

    int getCount(int n){
        String binaryN = Integer.toBinaryString(n);
        int count = 0;
        for(char c : binaryN.toCharArray()){
            if(c == '1') count++;
        }

        return count;
    }
}