class Solution {
    public static String solution(String s, int n) {
        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<arr.length;i++){
            char c = arr[i];

            if('a'<=c&&c<='z'){
                int number = (int)c+n;
                if(number>'z'){
                    number = 'a'+number%'z'-1;
                }
                c = (char)number;
            } else if('A'<=arr[i]&&arr[i]<='Z'){
                int number = (int)arr[i]+n;
                if(number>'Z'){
                    number = 'A'+number%'Z'-1;
                    System.out.println(number);
                }
                c = (char)number;
            }
            sb.append(c);
        }

        String answer = sb.toString();
        return answer;
    }
}
