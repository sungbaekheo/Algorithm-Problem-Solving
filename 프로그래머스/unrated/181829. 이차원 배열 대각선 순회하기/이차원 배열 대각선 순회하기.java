class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[r].length; c++){
                if(r+c <= k){
                    answer+=board[r][c];
                }
            }
        }
        
        return answer;
    }
}