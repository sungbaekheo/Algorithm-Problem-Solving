class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int size = board.length;
        
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                if(board[r][c] == 1){
                    for(int d=0; d<dr.length; d++){
                        int nr = r+dr[d];
                        int nc = c+dc[d];
                        
                        if(nr>=0 && nr<size && nc>=0 && nc<size && board[nr][nc] == 0){
                            board[nr][nc] = 2;
                        }
                    }
                }
            }
        }
        
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                if(board[r][c] == 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}