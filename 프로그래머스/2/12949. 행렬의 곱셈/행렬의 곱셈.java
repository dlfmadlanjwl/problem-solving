class Solution {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int y = arr1.length;
        int x = arr2[0].length;

        int[][] arr = new int[y][x];

        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                arr[i][j] = 0;
                for(int k=0;k<arr1[i].length;k++){
                    arr[i][j] += arr1[i][k]*arr2[k][j];
                }
            }
        }

        return arr;
    }
}
