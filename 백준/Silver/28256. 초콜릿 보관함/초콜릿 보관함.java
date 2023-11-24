import java.io.*;
import java.util.*;

public class Main {
    static char[][] isExist;
    static boolean[][] isVisited;
    static int cnt;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            isExist = new char[3][3];
            isVisited = new boolean[3][3];
            for(int i=0;i<3;i++){
                String str = br.readLine();
                for(int j=0;j<3;j++){
                    isExist[j][i] = str.charAt(j);
                }
            }
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            for(int j=0;j<n;j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(isExist[i][j]=='O'&&!isVisited[i][j]){
                        cnt = 1;
                        search(j,i);
                        res.add(cnt);
                    }
                }
            }
            Collections.sort(list);
            Collections.sort(res);
            boolean isTrue = true;
            if(list.size()!=res.size()){
                isTrue = false;
            }else{
                for(int i=0;i<list.size();i++){
                    if(res.get(i)!=list.get(i)){
                        isTrue=false;
                    }
                }
            }
            if(isTrue){
                sb.append(1+"\n");
            }else{
                sb.append(0+"\n");
            }
        }
        System.out.print(sb);
    }
    static void search(int x, int y){
        isVisited[y][x] = true;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        for(int i=0;i<4;i++){
            int x2 = x+dx[i];
            int y2 = y+dy[i];
            if(x2>=0&&x2<=2&&y2>=0&&y2<=2){
                if(isExist[y2][x2]=='O'&&!isVisited[y2][x2]){
                    search(x2,y2);
                    cnt++;
                }
            }
        }
    }
}