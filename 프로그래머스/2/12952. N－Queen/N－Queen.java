import java.util.*;

class Solution {
    int count = 0;
    public int solution(int n) {
        find(n, new ArrayList<>());
        return count;
    }
    
    void find(int n, List<Integer> list){
        if(n == list.size()) {
            count++;
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(list.size() == 0) {
                list.add(i);
                find(n, list);
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
                    find(n, list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}