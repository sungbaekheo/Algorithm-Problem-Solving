class Solution {
    public String solution(int[] food) {
        String answer = "";
        String reversed = "";
        
        for(int i=1; i<food.length; i++){
            int repeatNum = food[i]/2;
            for(int j=0; j<repeatNum; j++){
                answer+=i;
                reversed = i + reversed;
            }
        }
        
        return answer + 0 + reversed;
    }
}