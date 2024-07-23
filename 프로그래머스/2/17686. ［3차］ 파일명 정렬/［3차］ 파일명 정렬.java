import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<>(){
            public int compare(String a, String b){
                String[] aParts = separateName(a);
                String[] bParts = separateName(b);
                String aHead = aParts[0];
                String bHead = bParts[0];
                int aNumber = Integer.parseInt(aParts[1]);
                int bNumber = Integer.parseInt(bParts[1]);
                
                if(!aParts[0].equals(bParts[0])){
                    for(int i=0;i<Math.min(aHead.length(),bHead.length());i++){
                        if(aHead.charAt(i) != bHead.charAt(i)){
                            return aHead.charAt(i) - bHead.charAt(i);
                        }
                    }
                    return aHead.length() - bHead.length();
                }else if(aNumber != bNumber){
                    return aNumber - bNumber;
                }
                return 0;
            }
        });
        return files;
    }
    
    String[] separateName(String file){
        int numStartIdx = 0;
        for(int i=0;i<file.length();i++){
            if(Character.isDigit(file.charAt(i))){
                numStartIdx = i;
                break;
            }
        }
        int numEndIdx = numStartIdx;
        for(int i=numStartIdx+1;i<file.length();i++){
            if(Character.isDigit(file.charAt(i))){
                numEndIdx = i;
            }else break;
        }
        
        String[] arr = new String[2];
        arr[0] = file.substring(0, numStartIdx).toLowerCase();
        arr[1] = file.substring(numStartIdx, numEndIdx+1);
        return arr;
    }
}