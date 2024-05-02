import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        List<Integer>[][] res = new List[n+1][2];
        for(int i=0;i<res.length;i++){
            res[i][0] = new ArrayList<>();
            res[i][1] = new ArrayList<>();
        }

        for(int i=0;i<results.length;i++){
            int a = results[i][0];
            int b = results[i][1];
            res[a][0].add(b);
            res[b][1].add(a);
        }

        int answer = 0;

        for(int i=1;i<=n;i++){
            Set<Integer> set = new HashSet<>();
            winBfs(res, i, set);
            loseBfs(res, i, set);

            if(set.size() == n) answer++;
        }

        return answer;
    }

    void winBfs(List<Integer>[][] res, int index, Set<Integer> set){
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[res.length];

        q.add(index);
        while(!q.isEmpty()){
            int x = q.poll();
            isVisited[x] = true;
            set.add(x);
            for(int i=0;i<res[x][0].size();i++){
                if(!isVisited[res[x][0].get(i)]){
                    q.add(res[x][0].get(i));
                }
            }
        }
    }
    void loseBfs(List<Integer>[][] res, int index, Set<Integer> set){
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[res.length];

        q.add(index);
        while(!q.isEmpty()){
            int x = q.poll();
            isVisited[x] = true;
            set.add(x);
            for(int i=0;i<res[x][1].size();i++){
                if(!isVisited[res[x][1].get(i)]) {
                    q.add(res[x][1].get(i));
                }
            }
        }
    }
}