import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        for(int i=0;i<orders.length;i++){
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);
        }
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<orders.length;i++){
            String menus = orders[i];
            char[] list = menus.toCharArray();
            Set<String> result = new HashSet<>();
            createMenu("", 0, list, result);

            List<String> res = result.stream().filter(str->Arrays.stream(course).anyMatch(x->x==str.length())).collect(Collectors.toList());
            for(int j=0;j<res.size();j++){
                if(map.containsKey(res.get(j))){
                    map.replace(res.get(j),map.get(res.get(j))+1);
                }else{
                    map.put(res.get(j),1);
                }
            }
        }

        int[] maxCounts = new int[course.length];
        for(int i=0;i<course.length;i++){
            for(String key:map.keySet()){
                if(key.length()==course[i] && map.get(key)>maxCounts[i]){
                    maxCounts[i] = map.get(key);
                }
            }
        }
        List<String> answer = new ArrayList<>();
        for(int i=0;i<maxCounts.length;i++) {
            for (String key : map.keySet()) {
                if (map.get(key) == maxCounts[i] && maxCounts[i] >= 2 && key.length()==course[i]) {
                    answer.add(key);
                }
            }
        }
        sortAlphabet(answer);
        return answer.stream().toArray(String[]::new);
    }

    private void createMenu(String str, int index, char[] list, Set<String> result){
        if(str.length()>=2) result.add(str);
        if(index<list.length){
            createMenu(str+list[index], index+1, list, result);
            createMenu(str, index+1, list, result);
        }
    }

    private void sortAlphabet(List<String> res){
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len = Math.min(o1.length(), o2.length());
                for(int i=0;i<len;i++){
                    if(o1.charAt(i)==o2.charAt(i)){
                        continue;
                    }
                    return o1.charAt(i) - o2.charAt(i);
                }
                return o1.length() - o2.length();
            }
        });
    }
}