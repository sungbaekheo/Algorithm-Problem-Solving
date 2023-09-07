class Solution {
    
    int[] dr = new int[] {0, 0, 1, -1};
    int[] dc = new int[] {1, -1, 0, 0};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        int H = park.length;
        int W = park[0].length();
        
        char[][] parkMap = new char[H][W];
        Position standOn = null;
        
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                parkMap[i][j] = park[i].charAt(j);
                
                if(parkMap[i][j] == 'S'){
                    standOn = new Position(i, j);
                }
            }
        }
        
        return findTheDog(standOn, parkMap, routes);
    }
    
    public int[] findTheDog(Position standOn, char[][] parkMap, String[] routes){
        
        for(int i=0; i<routes.length; i++){
            char op = routes[i].charAt(0);
            int n = routes[i].charAt(2) - '0';
            
            int d = 0;
            boolean isMovable = true;
            
            switch(op){
                case 'E': d = 0; break;
                case 'W': d = 1; break;
                case 'S': d = 2; break;
                case 'N': d = 3; break;
            }
            
            int nextR = standOn.r;
            int nextC = standOn.c;
            for(int j=0; j<n; j++){
                nextR+=dr[d];
                nextC+=dc[d];
                if(!checkMovable(parkMap, nextR, nextC)){
                    isMovable = false;
                    break;
                }
            }
            
            if(isMovable){
                standOn = new Position(nextR, nextC);
            }
        }
        
        return new int[] {standOn.r, standOn.c};
    }
    
    public boolean checkMovable(char[][] parkMap, int r, int c){
        if(r < 0 || r >= parkMap.length || c < 0 || c >= parkMap[0].length || parkMap[r][c] == 'X'){
            return false;
        }
        return true;
    }
}

class Position{
    int r;
    int c;
    
    public Position(int r, int c){
        this.r = r;
        this.c = c;
    }
}