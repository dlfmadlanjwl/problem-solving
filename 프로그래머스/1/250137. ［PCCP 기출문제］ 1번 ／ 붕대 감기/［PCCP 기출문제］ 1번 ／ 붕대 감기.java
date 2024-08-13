class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int idx = 0;
        int time = 0;
        int continued = 0;
        int currHealth = health;
        while(idx < attacks.length){
            if(time == attacks[idx][0]){
                continued = 0;
                currHealth -= attacks[idx][1];
                if(currHealth <= 0) return -1;
                idx++;
                
            } else{
                continued++;
                if(continued == bandage[0]) {
                    currHealth += bandage[2];
                    continued = 0;
                }
                currHealth += bandage[1];
                if(currHealth > health) currHealth = health;
            }
            time++;
        }
        
        return currHealth;
    }
}