import java.util.*;

class Solution {
    public int solution(int[] toppings) {
        Map<Integer, Integer> big = new HashMap<>();
        Map<Integer, Integer> small = new HashMap<>();
        for(int topping : toppings){
            big.put(topping, big.getOrDefault(topping, 0)+1);
        }
        int result = 0;
        for(int topping : toppings){
            small.put(topping, small.getOrDefault(topping, 0)+1);
            
            if(big.get(topping)==1){
                big.remove(topping);
            }else{
                big.replace(topping, big.get(topping)-1);   
            }
            
            if(small.keySet().size() == big.keySet().size()){
                result++;
            }
        }
        
        return result;
    }
}