class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int idx = 0;
        
        for(int i=0; i<section.length; i++){
            if(i==0){
                idx = section[i];
                answer++;
            } else {
                if(section[i]>idx+m-1){
                    idx = section[i];
                    answer++;
                }   
            }
        }
        
        return answer;
    }
}