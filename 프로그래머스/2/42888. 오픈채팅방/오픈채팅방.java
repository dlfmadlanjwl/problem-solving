import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        for(String info : record){
            String op = info.split(" ")[0];
            String id = info.split(" ")[1];
            if(op.equals("Enter") || op.equals("Change")){
                String nickname = info.split(" ")[2];
                map.put(id, nickname);
            }
        }
        
        List<String> list = new ArrayList<>();
        for(String info : record){
            String op = info.split(" ")[0];
            String id = info.split(" ")[1];
            if(op.equals("Enter")){
                list.add(map.get(id)+"님이 들어왔습니다.");
            }else if(op.equals("Leave")){
                list.add(map.get(id)+"님이 나갔습니다.");
            }
        }
        
        return list.toArray(new String[list.size()]);
    }
}