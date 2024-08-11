import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        String[] allWords = new String[words.length+1];
        allWords[0] = begin;

        for(int i=0;i<words.length;i++){
            allWords[i+1] = words[i];
        }
        List<Integer>[] graph = new List[allWords.length];
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<allWords.length;i++){
            for(int j=0;j<allWords.length;j++){
                if(i==j) continue;
                if(isChangeable(allWords[i], allWords[j])){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }

        boolean[] isVisited = new boolean[words.length+2];
        
        return dfs(graph, isVisited, allWords, 0, target, 0);
    }

    int dfs(List[] graph, boolean[] isVisited, String[] words, int now, String target,int depth){
        int min = 0;
        if(words[now].equals(target)){
            return depth;
        }

        isVisited[now] = true;

        for(int i=0;i<graph[now].size();i++){
            if(!isVisited[(int)graph[now].get(i)]){
                int result = dfs(graph, isVisited, words, (int)graph[now].get(i), target, depth+1);
                if(result > 0 && min == 0) min = result;
                else if(result > 0 && min != 0)min = Math.min(min, result);
            }
        }
        
        return min;
    }

    boolean isChangeable(String a, String b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)) count++;
        }

        return count == 1;
    }
}