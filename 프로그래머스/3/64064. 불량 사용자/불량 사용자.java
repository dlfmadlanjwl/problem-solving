import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private void count(Set<String> banned, String[][] bans, Set<Set<String>> banSet){
        if(banned.size() == bans.length){
            banSet.add(new HashSet<>(banned));
            return;
        }
        for(String id : bans[banned.size()]){
            if(banned.contains(id)) continue;
            banned.add(id);
            count(banned, bans, banSet);
            banned.remove(id);
        }
    }

    public int solution(String[] user_id, String[] banned_id){
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*','.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id->id.matches(banned)).toArray(String[]::new))
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(new HashSet<>(), bans, banSet);
        return banSet.size();
    }
}