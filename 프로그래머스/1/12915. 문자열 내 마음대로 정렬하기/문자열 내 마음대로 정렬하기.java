import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.charAt(n)!=b.charAt(n)){
                    return a.charAt(n)-b.charAt(n);
                }else{
                    for(int i=0;i<a.length();i++){
                        if(a.charAt(i)==b.charAt(i))continue;
                        return a.charAt(i) - b.charAt(i);
                    }
                }
                
                return 0;
            }
        };
        Arrays.sort(strings, comparator);
        return strings;
    }
}