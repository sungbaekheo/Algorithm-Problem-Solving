class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] ants = new int[] {5, 3, 1};
        
        for(int i=0; i<ants.length; i++){
            answer+=hp/ants[i];
            hp%=ants[i];
        }
        
        return answer;
    }
}