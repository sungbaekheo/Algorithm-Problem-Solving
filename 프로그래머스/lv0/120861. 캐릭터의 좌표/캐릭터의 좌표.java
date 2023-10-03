import java.util.Arrays;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        
        int[] pos = new int[] {0, 0};
        int xLimit = board[0]/2, yLimit = board[1]/2;
        
        for(String op : keyinput){
            switch(op){
                case "left":
                    if(pos[0] > -xLimit){
                        pos[0]--;    
                    }
                    break;
                case "right":
                    if(pos[0] < xLimit){
                        pos[0]++;
                    }
                    break;
                case "up":
                    if(pos[1] < yLimit){
                        pos[1]++;
                    }
                    break;
                case "down":
                    if(pos[1] > -yLimit){
                        pos[1]--;
                    }
                    break;
            }
        }
        
        return pos;
    }
}