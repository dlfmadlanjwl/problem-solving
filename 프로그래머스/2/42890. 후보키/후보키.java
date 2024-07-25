import java.util.*;

class Solution {
    List<Set<String>> list;
    public int solution(String[][] relation) {
        list = new ArrayList<>();
        for(int i=0;i<Math.pow(2, relation[0].length);i++){
            list.add(new HashSet<>());
        }
        
        for(String[] tuple : relation){
            dfs(tuple, "", "");
        }
        
        int answer = 0;
        
        List<Integer> keys = new ArrayList<>();
        for(int i=1;i<list.size();i++){
            if(list.get(i).size() == relation.length) 
                keys.add(i);
        }
        
        for(int i=0;i<keys.size();i++){
            boolean isTrue = true;
            for(int j=0;j<keys.size();j++){
                int a = keys.get(i);
                int b = keys.get(j);
                if(a == b) continue;
                if(a > b){
                    if((a & b) == b) {
                        isTrue = false;
                        break;
                    }
                }
            }
            if(isTrue) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(String[] tuple, String current, String num){
        if(num.length() == tuple.length){
            list.get(Integer.parseInt(num,2)).add(current);
            return;
        }
        
        dfs(tuple, current+tuple[num.length()], num+"1");
        dfs(tuple, current, num+"0");
    }
}