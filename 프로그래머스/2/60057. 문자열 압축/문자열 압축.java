class Solution {
    public static int solution(String s) {
        int res = Integer.MAX_VALUE;
        int len = s.length();
        StringBuilder sb;
        for(int i=1;i<=len;i++){
            sb = new StringBuilder();
            int cnt = 0;
            String beforeStr = "", str = "";

            for(int idx=0;idx<len;idx+=i){
                if(idx+i>=len) {
                    str = s.substring(idx,s.length());
                } else str = s.substring(idx,idx+i);

                if(beforeStr.equals(str)){
                    cnt++;
                } else {
                    if(cnt>1){
                        sb.append(cnt+beforeStr);
                    }else if(cnt==1) sb.append(beforeStr);

                    cnt = 1;
                }
                beforeStr = str;
            }
            if(cnt!=1){
                sb.append(cnt+str);
            } else sb.append(str);

            if(res>sb.length())res = sb.length();
        }

        return res;
    }
}