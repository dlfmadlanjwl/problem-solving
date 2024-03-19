class Solution {
    public static String solution(String s) {
        char[] arr = s.toCharArray();
        int idx = -1;
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            if(c==' '){
                idx = -1;
                continue;
            }
            idx += 1;
            if(idx%2==0){
                arr[i] = Character.toUpperCase(arr[i]);
            }else{
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }
        return new String(arr);
    }
}