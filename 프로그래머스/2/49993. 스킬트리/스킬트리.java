import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        List<Character> skills = new ArrayList<>();
        for(char c : skill.toCharArray()){
            skills.add(c);
        }
        
        int answer = 0;
        for(String skillTree : skill_trees){
            boolean isValid = true;
            String tree = "";
            for(char c : skillTree.toCharArray()){
                if(!skills.contains(c)) continue;
                tree += c;
            }

            for(int i=0;i<Math.min(tree.length(), skill.length());i++){
                if(tree.charAt(i) != skill.charAt(i)){
                    isValid = false;
                    break;
                }
            }
            if(isValid) answer++;
        }
        
        return answer;
    }
}