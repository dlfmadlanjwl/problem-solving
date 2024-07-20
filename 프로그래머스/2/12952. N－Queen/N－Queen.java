import java.util.*;

class Solution {
    public int solution(int n) {
        int count = find(n, new ArrayList<>());
        return count;
    }
    
    int find(int n, List<Integer> list){
        int count = 0;
        if(n == list.size()) {
            return 1;
        }
        
        for(int i=1;i<=n;i++){
            if(list.size() == 0) {
                list.add(i);
                count += find(n, list);
                list.remove(0);
            }else{
                int previous = list.get(list.size()-1);
                boolean isValid = true;
                for(int j=0;j<list.size();j++){
                    if(Math.abs(list.get(j) - i) == Math.abs(j - list.size()))
                        isValid = false;
                    if(list.get(j) == i) isValid = false;
                }
                if(isValid) {
                    list.add(i);
                    count += find(n, list);
                    list.remove(list.size()-1);
                }
            }
        }
        return count;
    }
}