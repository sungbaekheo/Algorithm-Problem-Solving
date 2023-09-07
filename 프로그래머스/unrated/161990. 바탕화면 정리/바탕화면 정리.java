class Solution {
    public int[] solution(String[] wallpaper) {        
        int h = wallpaper.length;
        int w = wallpaper[0].length();
        
        char[][] display = new char[h][w];
        
        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;
        
        for(int r=0; r<h; r++){
            for(int c=0; c<w; c++){
                display[r][c] = wallpaper[r].charAt(c);
                int paper = display[r][c];
                if(display[r][c] == '#'){
                    lux = r<lux? r:lux;
                    rdx = r+1>rdx? r+1:rdx;
                    luy = c<luy? c:luy;
                    rdy = c+1>rdy? c+1:rdy;
                }
            }
        }
        
        
        return new int[] {lux, luy, rdx, rdy};
    }
}