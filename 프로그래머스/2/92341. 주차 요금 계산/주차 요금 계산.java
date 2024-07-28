import java.util.*;

class Solution {   
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<Integer>> map = new HashMap<>();

        for(String record : records){
            int hour = Integer.parseInt(record.split(" ")[0].split(":")[0]);
            int minute = Integer.parseInt(record.split(" ")[0].split(":")[1]);
            String number = record.split(" ")[1];
            String IO = record.split(" ")[2];
            
            if(!map.keySet().contains(number)){
                map.put(number, new ArrayList<>());
            }
            
            if(IO.equals("IN")){
                map.get(number).add(60 * hour + minute);
            }else if(IO.equals("OUT")){
                map.get(number).add(60 * hour + minute);
            }
        }
        
        List<String> list = new ArrayList<>();
        for(String name : map.keySet()){
            list.add(name);
        }
        list.sort(new Comparator<>(){
            public int compare(String a, String b){
                int x = Integer.parseInt(a);
                int y = Integer.parseInt(b);
                
                return x - y;
            }
        });
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            List<Integer> history = map.get(list.get(i));
            System.out.println(list.get(i)+" ");
            int sum = 0;
            for(int j=0;j<history.size();j++){
                if(j % 2 == 0){
                    if(j == history.size()-1){
                        sum += (23 * 60 + 59) - history.get(j);
                    }
                } else {
                    sum += history.get(j) - history.get(j-1);
                }
            }
            if(sum <= fees[0]) answer[i] = fees[1];
            else {
                int fee = fees[1] + (int)Math.ceil(((double)sum-fees[0])/fees[2]) * fees[3];
                answer[i]  = fee;
            }            
        }
        return answer;
    }
}