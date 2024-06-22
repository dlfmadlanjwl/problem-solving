import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(num -> set.add(num));
        
        return set.size() < nums.length/2 ? set.size() : nums.length/2;
    }
}