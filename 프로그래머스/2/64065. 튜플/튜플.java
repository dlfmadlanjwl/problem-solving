import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length()-1);
        
        Map<Integer, Integer> map = new HashMap<>();
        String number = "";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                number += c;
            }else{
                if(!number.equals("")){
                    int n = Integer.parseInt(number);
                    map.put(n, map.getOrDefault(n, 0)+1);
                    number = "";
                } 
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int n : map.keySet()){
            list.add(n);
        }
        
        list.sort(new Comparator<>(){
            public int compare(Integer a, Integer b){
                return map.get(b) - map.get(a);
            }
        });
        
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}