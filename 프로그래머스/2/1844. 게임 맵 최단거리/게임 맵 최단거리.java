import java.util.Queue;
import java.util.LinkedList;

class Solution {
    boolean[][] visited;
    int[] dr = new int[] {-1, 1, 0, 0};
    int[] dc = new int[] {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        return findTheShortestWay(maps, new Position(0, 0, 1));
    }
    
    public int findTheShortestWay(int[][] maps, Position position){
        Queue<Position> q = new LinkedList<>();
        q.offer(position);
        visited[position.r][position.c] = true;
        
        while(!q.isEmpty()){
            Position curr = q.poll();
            
            if(curr.r == maps.length-1 && curr.c == maps[0].length-1){
                return curr.cnt;
            }
            
            for(int d=0; d<4; d++){
                int nr = curr.r+dr[d];
                int nc = curr.c+dc[d];
                
                if(nr<0 || nr>maps.length-1 || nc<0 || nc>maps[0].length-1 || visited[nr][nc]){
                    continue;
                }
                
                if(maps[nr][nc] == 1){
                    q.offer(new Position(nr, nc, curr.cnt+1));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
    
    class Position{
        int r;
        int c;
        int cnt;
        
        public Position(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}