class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        String oddSum = "";
        String evenSum = "";
        
        for(int i:num_list){
            if(i%2 == 0){
                evenSum+=String.valueOf(i);
            } else {
                oddSum+=String.valueOf(i);
            }
        }
        
        answer = Integer.parseInt(oddSum) + Integer.parseInt(evenSum);
        
        return answer;
    }
}