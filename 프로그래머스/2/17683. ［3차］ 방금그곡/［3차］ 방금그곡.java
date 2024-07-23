class Solution {
    public String solution(String m, String[] musicinfos) {
        m = m.replace("A#", "H")
            .replace("B#", "I")
            .replace("C#", "J")
            .replace("D#", "K")
            .replace("F#", "L")
            .replace("G#", "M");
        int maxTime = 0;
        String title = "";
        for(String musicinfo : musicinfos){
            String[] musicinfoArr = musicinfo.split(",");
            
            String melody = musicinfoArr[3];
            melody = melody.replace("A#", "H")
                .replace("B#", "I")
                .replace("C#", "J")
                .replace("D#", "K")
                .replace("F#", "L")
                .replace("G#", "M");
            
            int startH = Integer.parseInt(musicinfoArr[0].split(":")[0]);
            int startM = Integer.parseInt(musicinfoArr[0].split(":")[1]);
            int endH = Integer.parseInt(musicinfoArr[1].split(":")[0]);
            int endM = Integer.parseInt(musicinfoArr[1].split(":")[1]);
            
            int time = (endH-startH) * 60 + endM-startM;
            String radio = "";
            for(int i=0;i<time / melody.length();i++){
                radio += melody;
            }
            for(int i=0;i<time % melody.length();i++){
                radio += melody.charAt(i);
            }
            
            if(radio.contains(m) || m.contains(radio)){
                if(time > maxTime){
                    maxTime = time;
                    title = musicinfoArr[2];
                }
            }
        }
        
        return title==""?"(None)":title;
    }
}