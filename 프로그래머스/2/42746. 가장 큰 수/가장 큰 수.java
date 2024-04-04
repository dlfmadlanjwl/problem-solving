import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for(int i=0;i<numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2+o1) - Integer.parseInt(o1+o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(x->sb.append(x));

        if(Arrays.stream(arr).filter(x->x.equals("0")).collect(Collectors.toList()).size()==numbers.length){
            return "0";
        }
        return sb.toString();
    }
}