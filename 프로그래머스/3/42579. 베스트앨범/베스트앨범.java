import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, MusicList> map = new HashMap<>();
        
        for(int i=0;i<genres.length;i++){
            if(!map.keySet().contains(genres[i])){
                map.put(genres[i], new MusicList());
            }
            map.get(genres[i]).list.add(new Music(i, plays[i]));
            map.get(genres[i]).totalPlays += plays[i];
        }
        
        List<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort(new Comparator<String>() {
            public int compare(String a, String b) {
                return map.get(b).totalPlays - map.get(a).totalPlays;
            }
        });
        
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<genreList.size();i++){
            String genre = genreList.get(i);
            List<Music> list = map.get(genre).list;
            list.sort(new Comparator<Music>(){
                public int compare(Music a, Music b){
                    return b.plays - a.plays;
                }
            });
            
            answer.add(list.get(0).index);
            if(list.size() > 1) answer.add(list.get(1).index);
        }
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    class MusicList{
        List<Music> list = new ArrayList<>();
        int totalPlays = 0;
    }
    
    class Music{
        int index;
        int plays;
        Music(int index, int plays){
            this.index = index;
            this.plays = plays;
        }
    }
}