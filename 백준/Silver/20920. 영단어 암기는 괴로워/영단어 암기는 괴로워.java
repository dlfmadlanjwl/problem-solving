import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String>list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();

        for(int n=0;n<N;n++){
            String input = br.readLine();
            if(map.containsKey(input)){
                map.replace(input,map.get(input)+1);
            }
            if(input.length()>=M&&!map.containsKey(input)){
                map.put(input,1);
                list.add(input);
            }

        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1)==map.get(o2)){
                    return o2.length()-o1.length();
                }
                return map.get(o2)-map.get(o1);
            }
        };

        Collections.sort(list);
        Collections.sort(list,comparator);
        list.stream().forEach(x->sb.append(x+"\n"));

        System.out.print(sb);
    }
}
