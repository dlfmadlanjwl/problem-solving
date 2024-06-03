import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<players.length;i++){
            map.put(players[i], i);
        }
        for(String call : callings){
            int rank = map.get(call);
            String tmp = players[rank-1];
            map.replace(call, map.get(call)-1);
            map.replace(tmp, map.get(tmp)+1);
            players[rank-1] = players[rank];
            players[rank] = tmp;
        }
        
        return players;
    }
}