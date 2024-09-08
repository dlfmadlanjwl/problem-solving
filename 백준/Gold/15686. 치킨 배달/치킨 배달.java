import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, m;
    static int[][] map;
    static List<Chicken> chickenList;
    static List<Home> homeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        chickenList = new ArrayList<>();
        homeList = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) homeList.add(new Home(i, j));
                if(map[i][j] == 2) chickenList.add(new Chicken(i, j));
            }
        }

        List<Chicken> selectedChicken = new ArrayList<>();
        int answer = dfs(0, selectedChicken);
        System.out.print(answer);
    }

    static int dfs(int idx, List<Chicken> selectedChicken){
        int min = Integer.MAX_VALUE;

        if(selectedChicken.size() == m){
            return calculateDistance(selectedChicken);
        }
        for(int i=idx;i<chickenList.size();i++){
            Chicken chicken = chickenList.get(i);

            selectedChicken.add(chicken);
            int distance = dfs(i+1, selectedChicken);
            selectedChicken.remove(selectedChicken.size()-1);

            min = Math.min(min, distance);
        }

        return min;
    }

    static int calculateDistance(List<Chicken> selectedChicken){
        int sum = 0;
        for(Home h : homeList){
            int min = Integer.MAX_VALUE;
            for(Chicken c : selectedChicken){
                int distance = Math.abs(c.y - h.y) + Math.abs(c.x - h.x);
                min = Math.min(min, distance);
            }
            sum += min;
        }

        return sum;
    }

    static class Chicken{
        int y;
        int x;

        Chicken(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static class Home{
        int y;
        int x;

        Home(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}