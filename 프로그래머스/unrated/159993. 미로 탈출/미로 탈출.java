import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    char[][] maze = null;
    boolean[][][] visited = null;
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    int answer = -1;
    
    public int solution(String[] maps) {
        
        maze = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()][2];
        
        for(int i=0; i<maps.length; i++){
            maze[i] = maps[i].toCharArray();
        }
        
        run:for(int r=0; r<maze.length; r++){
            for(int c=0; c<maze[r].length; c++){
                if(maze[r][c] == 'S'){
                    findExit(new Position(r, c, 0, 0));
                    break run;
                }
            }
        }
        
        answer = answer == -1? -1:answer;
        
        return answer;
    }
    
    public void findExit(Position start){
        Queue<Position> q = new LinkedList<>();
        q.offer(start);
        visited[start.r][start.c][start.key] = true;
        
        while(!q.isEmpty()){
            Position now = q.poll();
            
            if(now.key == 1 && maze[now.r][now.c] == 'E'){
                answer = now.count;
                break;
            } else if(now.key == 0 && maze[now.r][now.c] == 'L'){
                now.key++;
            }
            for(int d=0; d<4; d++){
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if(nr<0 || nr>=maze.length || nc<0 || nc>=maze[nr].length){
                    continue;
                }
                if(maze[nr][nc] == 'X' || visited[nr][nc][now.key]){
                    continue;
                }
                visited[nr][nc][now.key] = true;
                q.offer(new Position(nr, nc, now.count+1, now.key));
            }
        }
    }
}

class Position{
    int r;
    int c;
    int count;
    int key;
    
    public Position(int r, int c, int count, int key){
        this.r = r;
        this.c = c;
        this.count = count;
        this.key = key;
    }
}