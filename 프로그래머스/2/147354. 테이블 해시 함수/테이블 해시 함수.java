import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<data.length;i++){
            list.add(new ArrayList<>());
            for(int j=0;j<data[0].length;j++){
                list.get(i).add(data[i][j]);
            }
        }
        
        list.sort(new Comparator<>(){
            public int compare(List<Integer> a, List<Integer> b){
                if(a.get(col-1).equals(b.get(col-1))){
                    return b.get(0) - a.get(0);
                }
                return a.get(col-1) - b.get(col-1);
            }
        });
        
        int answer = 0;
        for(int i=row_begin-1;i<=row_end-1;i++){
            int sum = 0;
            for(int j=0;j<list.get(i).size();j++){
                sum += list.get(i).get(j) % (i+1);
            }
            System.out.println();
            answer = answer ^ sum;
        }
        
        return answer;
    }
}