class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int len = Integer.MAX_VALUE;
        
        while(true){
            if(sum<k){
                end++;
                if(end>=sequence.length){
                    break;
                }
                sum+=sequence[end];
            } else if(sum>k){
                sum-=sequence[start++];
            } else {
                int tempLen = end-start+1;
                
                if(tempLen < len){
                    len = tempLen;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum-=sequence[start++];
            }
        }
        
        return answer;
    }
}