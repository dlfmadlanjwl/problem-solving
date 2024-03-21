class Solution {
    public static String solution(String new_id) {
        String res = step1(new_id);
        res = step2(res);
        res = step3(res);
        res = step4(res);
        res = step5(res);
        res = step6(res);
        res = step4(res);
        res = step7(res);

        return res;
    }

    static String step1(String s){
        return s.toLowerCase();
    }

    static String step2(String s){
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isAlphabetic(c)||Character.isDigit(c)){
                sb.append(c);
                continue;
            }
            if(c=='-'||c=='_'||c=='.'){
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String step3(String s){
        boolean check = false;
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c!='.'){
                sb.append(c);
                check = false;
            }else{
                if(!check){
                    sb.append(c);
                    check = true;
                }
            }
        }
        return sb.toString();
    }

    static String step4(String s){
        String str = s;
        if(str.charAt(0)=='.'){
            str = s.substring(1);
        }
        if(str.length()!=0){
            if(s.charAt(s.length()-1)=='.'){
                str = str.substring(0,str.length()-1);
            }
        }
        return str;
    }

    static String step5(String s){
        if(s.isEmpty()){
            return "a";
        }
        return s;
    }

    static String step6(String s){
        if(s.length()>15){
            return s.substring(0,15);
        }
        return s;
    }

    static String step7(String s) {
        String str = s;
        while(str.length()<3){
            str = str + str.charAt(str.length()-1);
        }
        return str;
    }
}