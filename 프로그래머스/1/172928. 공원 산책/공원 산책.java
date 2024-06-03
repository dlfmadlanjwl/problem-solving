class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = 0, y = 0;
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                if(park[i].charAt(j) == 'S'){
                    y = i;
                    x = j;
                }
            }
        }
        for(String route : routes){
            String direction = route.split(" ")[0];
            int dist = Integer.parseInt(route.split(" ")[1]);
            int newY = y;
            int newX = x;
            boolean isBlocked = false;
            switch (direction){
                case "N":
                    newY = y - dist;
                    break;
                case "S":
                    newY = y + dist;
                    break;
                case "W":
                    newX = x - dist;
                    break;
                case "E":
                    newX = x + dist;
                    break;
            }
            if(newY >= 0 && newY < park.length && newX >= 0 && newX < park[0].length()){
                if(newY > y){
                    for(int i=y;i<=newY;i++){
                        if(park[i].charAt(x) == 'X') isBlocked = true;
                    }
                }else if(newY < y){
                    for(int i=newY;i<=y;i++){
                        if(park[i].charAt(x) == 'X') isBlocked = true;
                    }
                }else if(newX > x){
                    for(int i=x;i<=newX;i++){
                        if(park[y].charAt(i) == 'X') isBlocked = true;
                    }
                }else{
                    for(int i=newX;i<=x;i++){
                        if(park[y].charAt(i) == 'X') isBlocked = true;
                    }
                }
                if(isBlocked) continue;
                y = newY;
                x = newX;
            }
        }

        return new int[]{y,x};
    }
}