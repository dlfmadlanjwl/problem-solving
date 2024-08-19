import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String,List<Ticket>> map = new HashMap<>();
        for(String[] ticket : tickets){
            map.put(ticket[0], new ArrayList<>());
            map.put(ticket[1], new ArrayList<>());
        }
        for(String[] ticket : tickets){
            map.get(ticket[0]).add(new Ticket(ticket[1]));
        }
        for(List<Ticket> list : map.values()){
            Collections.sort(list, new Comparator<>(){
                public int compare(Ticket a, Ticket b){
                    return a.dest.compareTo(b.dest);
                }
            });
        }
        List<String> path = new ArrayList<>();
        path.add("ICN");

        return dfs(map, path, tickets.length+1).toArray(new String[path.size()]);
    }

    List<String> dfs(Map<String, List<Ticket>> map, List<String> path, int target){
        if(target == path.size()){
            return path;
        }

        for(int i=0;i<map.get(path.get(path.size()-1)).size();i++){
            Ticket dest = map.get(path.get(path.size()-1)).get(i);
            if(!dest.isUsed){
                path.add(dest.dest);
                dest.isUsed = true;
                List<String> list = dfs(map, path, target);
                if(list!=null) return list;
                path.remove(path.size()-1);
                dest.isUsed = false;
            }
        }
        return null;
    }

    class Ticket{
        String dest;
        boolean isUsed = false;
        Ticket(String dest){
            this.dest = dest;
        }
    }
}