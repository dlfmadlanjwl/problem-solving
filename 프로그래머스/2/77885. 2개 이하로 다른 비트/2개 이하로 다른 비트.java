class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            long n = numbers[i];
            if(n % 2 == 0){
                answer[i] = n + 1;
            } else {
                String binary = "0" + Long.toBinaryString(n);
                int idx = binary.lastIndexOf('0');
                binary = binary.substring(0, idx) + 1 + 0 + binary.substring(idx+2);
                
                answer[i] = Long.parseLong(binary, 2);
            }
        }
        
        return answer;
    }
}