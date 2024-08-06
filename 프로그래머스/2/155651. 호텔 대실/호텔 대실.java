import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] bookTime = new int[book_time.length][2];
        for(int i=0;i<bookTime.length;i++){
            int startH = Integer.parseInt(book_time[i][0].split(":")[0]);
            int startM = Integer.parseInt(book_time[i][0].split(":")[1]);
            int endH = Integer.parseInt(book_time[i][1].split(":")[0]);
            int endM = Integer.parseInt(book_time[i][1].split(":")[1]);
            
            bookTime[i][0] = startH * 60 + startM;
            bookTime[i][1] = endH * 60 + endM + 10;
        }
        
        Arrays.sort(bookTime, new Comparator<>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        
        List<Integer> list = new ArrayList<>();
        
        for(int[] time : bookTime){
            Collections.sort(list);
            boolean newRoom = true;
            for(int i=0;i<list.size();i++){
                if(list.get(i) <= time[0]){
                    list.remove(i);
                    list.add(time[1]);
                    newRoom = false;
                    break;
                }
            }
            if(newRoom){
                list.add(time[1]);
            }
        }
        
        return list.size();
    }
}