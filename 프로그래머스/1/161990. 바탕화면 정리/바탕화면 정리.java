class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int minY = n, minX = m, maxY = -1, maxX = -1; 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(wallpaper[i].charAt(j)=='#'){
                    if(i < minY) minY = i;
                    if(j < minX) minX = j;
                    if(i > maxY) maxY = i;
                    if(j > maxX) maxX = j;
                }
            }
        }
        return new int[]{minY, minX, maxY+1, maxX+1};
    }
}