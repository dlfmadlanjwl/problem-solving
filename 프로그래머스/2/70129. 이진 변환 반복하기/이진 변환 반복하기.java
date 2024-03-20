class Solution {
    static int zeroCnt = 0;
    public static int[] solution(String s) {
        int cycle = 0;
        String str = s;
        while(true){
            cycle++;
            str = contraction(str);
            str = change(str);
            if(str.equals("1")){
                break;
            }
        }
        int[] answer = {cycle, zeroCnt};
        return answer;
    }

    static String contraction(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zeroCnt++;
            }else{
                sb.append("1");
            }
        }
        return sb.toString();
    }

    static String change(String s){
        int len = s.length();
        return Integer.toString(len,2);
    }
}