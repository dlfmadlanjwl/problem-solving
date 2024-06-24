class Solution {
    static int count = 0;
    public int solution(int n, String[] data) {
        count = 0;
        String[] members = {"A", "C", "F", "J", "M", "N", "R", "T"};
        boolean[] visited = new boolean[members.length];

        dfs("", members, visited, data);

        return count;
    }

    void dfs(String str, String[] members, boolean[] visited, String[] data){
        if(str.length() == members.length){
            if(checkCondition(str, data)){
                count++;
            }
            return;
        }
        for(int i=0;i<members.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(str+members[i], members, visited, data);
                visited[i] = false;
            }
        }
    }

    boolean checkCondition(String str, String[] data){
        for(String condition : data){
            char a = condition.charAt(0);
            char b = condition.charAt(2);
            char op = condition.charAt(3);
            int dist = condition.charAt(4) - '0';
            int actualDist = Math.abs(str.indexOf(a) - str.indexOf(b)) - 1;
            if(op == '='){
                if(actualDist != dist) return false;
            } else if(op == '<'){
                if(!(actualDist < dist)) return false;
            } else if(op == '>'){
                if(!(actualDist > dist)) return false;
            }
        }
        return true;
    }
}