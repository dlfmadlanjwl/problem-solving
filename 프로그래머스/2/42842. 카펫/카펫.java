class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 3;
        while(width<2500){
            for(int i=3;i<=width;i++){
                int currentBrown = 2*width + 2*i - 4;
                int currentYellow = (width-2)*(i-2);
                if(currentBrown == brown && currentYellow == yellow){
                    return new int[]{width, i};
                }
            }
            width++;
        }
        return null;
    }
}