import java.util.Arrays;

class Solution {
    public int[] solution(int n) {

        int[][] plane = new int[n][n];
        int[] now = {0, 0};
        
        int[] dr = new int[] {1, 0, -1};
        int[] dc = new int[] {0, 1, -1};
        
        int num = 1;
        plane[0][0] = num++;
        
        for(int i=0; i<=(n-1)/3; i++){
            for(int d=0; d<3; d++){
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                
                while(nr >= 0 && nr < n && nc >= 0 && nc < n && plane[nr][nc] == 0){
                    plane[nr][nc] = num++;
                    now[0] = nr;
                    now[1] = nc;
                    
                    nr+=dr[d];
                    nc+=dc[d];
                }
            }
        }
        
        int[] answer = new int[num-1];
        
        int idx = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                answer[idx++] = plane[i][j];
            }
        }
        
        return answer;
    }
}